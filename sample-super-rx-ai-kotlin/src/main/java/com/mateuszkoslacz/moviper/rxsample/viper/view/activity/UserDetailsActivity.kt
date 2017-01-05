package com.mateuszkoslacz.moviper.rxsample.viper.view.activity

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperLceAiPassiveActivity
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import com.mateuszkoslacz.moviper.rxsample.R
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import com.mateuszkoslacz.moviper.server.MoviperPresentersDispatcher
import kotlinx.android.synthetic.main.activity_user_details.*
import rx.Observable
import rx.subjects.PublishSubject

class UserDetailsActivity :
        ViperLceAiPassiveActivity<LinearLayout, User, UserDetailsContract.View>(),
        UserDetailsContract.View, UserDetailsContract.ViewHelper {

    override val avatarClicks: Observable<String>
        get() = mAvatarClicks

    override val avatarImageView: View
        get() = avatar

    internal var mAvatarClicks = PublishSubject.create<String>()

    override fun bindDataToViews(user: User) {
        login?.text = user.login
        url?.text = user.url
        name?.text = user.name
        company?.text = user.company
        blog?.text = user.blog
        location?.text = user.location
        email?.text = user.email
        Glide.with(this)
                .load(user.avatarUrl)
                .into(avatar)
        avatar?.setOnClickListener { mAvatarClicks.onNext(user.avatarUrl) }
    }

    override fun setData(user: User) = bindDataToViews(user)

    override fun getErrorMessage(e: Throwable, pullToRefresh: Boolean): String = e.message!!

    override fun loadData(pullToRefresh: Boolean) {}

    override fun createPresenter(): ViperPresenter<UserDetailsContract.View> =
            MoviperPresentersDispatcher.getInstance().getPresenterForView(this)
                    as ViperPresenter<UserDetailsContract.View>

    override fun getLayoutId(): Int = R.layout.activity_user_details

    companion object {

        val USER_EXTRA = "USER_EXTRA"

        fun start(context: Context, user: User) {
            context.startActivity(getStartingIntent(context, user))
        }

        fun getStartingIntent(context: Context, user: User): Intent {
            val starter = Intent(context, UserDetailsActivity::class.java)
            starter.putExtra(USER_EXTRA, user.login)
            return starter
        }
    }
}
