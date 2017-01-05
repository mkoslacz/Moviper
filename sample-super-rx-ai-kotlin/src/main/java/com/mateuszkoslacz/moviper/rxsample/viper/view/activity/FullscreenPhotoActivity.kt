package com.mateuszkoslacz.moviper.rxsample.viper.view.activity

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import com.bumptech.glide.Glide
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperAiActivity
import com.mateuszkoslacz.moviper.rxsample.R
import com.mateuszkoslacz.moviper.rxsample.viper.contract.FullscreenPhotoContract
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.FullscreenPhotoPresenter
import kotlinx.android.synthetic.main.activity_fullscreen_photo.*

class FullscreenPhotoActivity :
        ViperAiActivity<FullscreenPhotoContract.View, FullscreenPhotoContract.Presenter>(),
        FullscreenPhotoContract.View {

    override fun setPhoto(photoUrl: String) {
        Glide.with(this).load(photoUrl).into(photo)
    }

    override fun createPresenter(): FullscreenPhotoContract.Presenter =
            FullscreenPhotoPresenter(intent.extras)

    override fun getLayoutId(): Int = R.layout.activity_fullscreen_photo

    companion object {

        val PHOTO_URL_EXTRA_STRING = "PHOTO_URL_EXTRA_STRING"

        fun start(activity: Activity, avatarUrl: String, avatarView: View) {
            val starter = Intent(activity, FullscreenPhotoActivity::class.java)
            starter.putExtra(PHOTO_URL_EXTRA_STRING, avatarUrl)
            val optionsCompat = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(activity,
                            avatarView,
                            activity.getString(R.string.avatar_transition))
            activity.startActivity(starter, optionsCompat.toBundle())
        }
    }
}
