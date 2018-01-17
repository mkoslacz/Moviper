package com.mateuszkoslacz.moviper3.presentersdispatcher

import android.app.Activity
import android.app.Fragment
import android.support.annotation.VisibleForTesting
import android.util.SparseArray

import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter
import com.mateuszkoslacz.moviper3.iface.view.ViperView

import java.util.Random

/**
 * Created by bwilk on 12/22/16.
 */
class MoviperPresentersDispatcher protected constructor() {
    private val mPresenters = SparseArray<ViperRxPresenter<*>>() // TODO: 27.12.2016 SparseArray or HashMap?

    fun getPresenterForView(view: ViperView): ViperRxPresenter<*> {
        return view.args?.getInt(EXTRA_VIEW_ID)?.let {  mPresenters.get(it) } ?: throw IllegalStateException("View does not have viewId") // TODO when could it happen?
    }

    /**
     * It starts an [Activity] with selected presenter configured in a way provided in the
     * given [com.mateuszkoslacz.moviper3.presentersdispatcher.ActivityStarter].
     *
     *
     *
     * Given [Activity] has to be passive (from package [com.mateuszkoslacz.moviper3.base.view.activity.autoinject.passive]),
     * and has to return value from [.getPresenterForView] method in [ ][MvpActivity.createPresenter].
     */
    fun startActivity(activityStarter: com.mateuszkoslacz.moviper3.presentersdispatcher.ActivityStarter) {
        val viewId = Random().nextInt()
        activityStarter.intent.putExtra(EXTRA_VIEW_ID, viewId)
        mPresenters.put(viewId, activityStarter.presenter)
        activityStarter.context.startActivity(activityStarter.intent)
    }

    /**
     * It processes given [MvpFragment] to start with a given presenter.
     *
     *
     *
     * Given [Fragment] has to be passive (from package [com.mateuszkoslacz.moviper3.base.view.fragment.autoinject.passive]),
     * and has to return value from [.getPresenterForView] method in [ ][MvpFragment.createPresenter].
     *
     *
     * The alternative way to achieve this is to set the fragment presenter like this:
     *
     * <blockquote><pre>
     * SomeViperFragment fragment = new SomeViperFragment();
     * fragment.setPresenter(somePresenter);
    </pre></blockquote> *
     *
     * and return the current presenter if it's not null inside fragment, in [ ][MvpFragment.createPresenter]
     *
     * <blockquote><pre>
     * public SomePresenter createPresenter() {
     * if (presenter != null) return presenter;
     * else return new SomePresenter();
     * }
    </pre></blockquote> *
     *
     */
    fun startFragment(fragment: MvpFragment<*, *>, presenter: ViperRxPresenter<*>): MvpFragment<*, *> {
        val viewId = Random().nextInt()
        val arguments = fragment.getArguments()
        arguments!!.putInt(EXTRA_VIEW_ID, viewId)
        mPresenters.put(viewId, presenter)
        fragment.setArguments(arguments)
        return fragment
    }

    companion object {

        private val EXTRA_VIEW_ID = "EXTRA_VIEW_ID"
        @set:VisibleForTesting
        var instance: MoviperPresentersDispatcher? = null
            get() {
                if (field == null) {
                    instance = MoviperPresentersDispatcher()
                }
                return field
            }
    }

}
