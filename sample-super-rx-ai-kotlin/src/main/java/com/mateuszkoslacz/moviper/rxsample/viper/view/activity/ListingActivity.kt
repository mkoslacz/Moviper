package com.mateuszkoslacz.moviper.rxsample.viper.view.activity

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ImageView
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import com.mateuszkoslacz.moviper.rxsample.R
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.ListingPresenter
import com.mateuszkoslacz.moviper.rxsample.viper.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_listing.*
import rx.Observable
import rx.subjects.PublishSubject

open class ListingActivity :
        ViperAiPassiveActivity<ListingContract.View>(),
        ListingContract.View,
        UserAdapter.UserClickListener {

    override val userClicks: Observable<User>
        get() = mUserClicks

    internal var mUserClicks = PublishSubject.create<User>()

    private var mAdapter: UserAdapter? = null


    override fun setUserList(userList: List<User>) = mAdapter?.setUserList(userList)!!

    private fun prepareRecyclerView() {
        mAdapter = UserAdapter(this)
        recycler_view?.layoutManager = LinearLayoutManager(this)
        recycler_view?.itemAnimator = DefaultItemAnimator()
        recycler_view?.adapter = mAdapter
    }

    override fun onUserClick(user: User) = mUserClicks.onNext(user)

    override fun onDestroy() {
        super.onDestroy()
        mAdapter = null
    }

    override fun showError(throwable: Throwable) {
        errorView?.visibility = View.VISIBLE
        loadingView?.visibility = View.INVISIBLE
        recycler_view?.visibility = View.INVISIBLE
        errorView?.text = throwable.message
    }

    override fun showLoading() {
        errorView?.visibility = View.INVISIBLE
        loadingView?.visibility = View.VISIBLE
        recycler_view.visibility = View.INVISIBLE
    }

    override fun showContent() {
        errorView?.visibility = View.INVISIBLE
        loadingView?.visibility = View.INVISIBLE
        recycler_view.visibility = View.VISIBLE
    }

    override fun createPresenter(): ViperPresenter<ListingContract.View> = ListingPresenter()

    override fun injectViews() = prepareRecyclerView()

    override fun getLayoutId(): Int = R.layout.activity_listing

    companion object {

        val PHOTO_URL_EXTRA_STRING = "PHOTO_URL_EXTRA_STRING"

        fun start(activity: Activity, avatarUrl: String, avatarImageView: ImageView) {
            val starter = Intent(activity, FullscreenPhotoActivity::class.java)
            starter.putExtra(PHOTO_URL_EXTRA_STRING, avatarUrl)

            val optionsCompat = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(activity,
                            avatarImageView,
                            activity.getString(R.string.avatar_transition))
            activity.startActivity(starter, optionsCompat.toBundle())
        }
    }
}
