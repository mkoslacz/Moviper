package com.mateuszkoslacz.moviper3.base.view

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback
import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter
import com.mateuszkoslacz.moviper3.iface.view.ViperView

/**
 * A DialogFragment that uses a [MvpPresenter] to implement a Model-View-Presenter
 * architecture
 *
 * @author Mateusz Koslacz
 * @since 1.0.0
 */
abstract class ViperAiPassiveDialogFragment<V : MvpView>
    : DialogFragment(), MvpDelegateCallback<V, ViperRxPresenter<V>>, MvpView, ViperView {

    @Suppress("MemberVisibilityCanPrivate")
    protected val mvpDelegate: FragmentMvpDelegate<*, *> by lazy {
        FragmentMvpDelegateImpl(this, this, true, true)
    }
    private lateinit var presenter: ViperRxPresenter<V>
    protected abstract val layoutId: Int

    override val args: Bundle?
        get() = arguments

    /**
     * Creates a new presenter instance, if needed. Will reuse the previous presenter instance if
     * [.setRetainInstance] is set to true. This method will be called from
     * [.onViewCreated]
     */
    abstract override fun createPresenter(): ViperRxPresenter<V>

    /**
     * **DO NOT** use this method because of a fact that this view should be completely passive
     * (independent from the presenter type)! <br></br>
     * Instead you should use getters to provide
     * event sources that will notify presenter after presenter's registration to them. To use
     * getPresenter() method you shall use non-passive Moviper view.
     *
     * @return raw [ViperRxPresenter], so you can't call any custom methods on it anyway
     */
    @Deprecated("Do not use this method if you want your view to be passive!")
    override fun getPresenter(): ViperRxPresenter<V> = presenter

    override fun setPresenter(presenter: ViperRxPresenter<V>) {
        this.presenter = presenter
    }

    @Suppress("UNCHECKED_CAST")
    override fun getMvpView(): V = this as V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(layoutId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectViews(view)
        mvpDelegate.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mvpDelegate.onDestroyView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpDelegate.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mvpDelegate.onDestroy()
    }

    override fun onPause() {
        super.onPause()
        mvpDelegate.onPause()
    }

    override fun onResume() {
        super.onResume()
        mvpDelegate.onResume()
    }

    override fun onStart() {
        super.onStart()
        mvpDelegate.onStart()
    }

    override fun onStop() {
        super.onStop()
        mvpDelegate.onStop()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mvpDelegate.onActivityCreated(savedInstanceState)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        mvpDelegate.onAttach(activity)
    }

    override fun onDetach() {
        super.onDetach()
        mvpDelegate.onDetach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mvpDelegate.onSaveInstanceState(outState)
    }

    @Suppress("MemberVisibilityCanPrivate")
    protected open fun injectViews(view: View) = Unit // stub
}
