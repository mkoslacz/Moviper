package com.mateuszkoslacz.moviper.rxsample.viper.routing

import android.app.Activity
import com.mateuszkoslacz.moviper.base.routing.BaseViewHelperRxRouting
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.FullscreenPhotoActivity

class UserDetailsRouting : BaseViewHelperRxRouting<Activity, UserDetailsContract.ViewHelper>(), UserDetailsContract.Routing {

    override fun startFullscreenPhotoActivity(photoUrl: String) {
        if (isViewHelperAttached) {
            FullscreenPhotoActivity.start(relatedContext!!, photoUrl,
                    viewHelper!!.avatarImageView)
        }
    }
}