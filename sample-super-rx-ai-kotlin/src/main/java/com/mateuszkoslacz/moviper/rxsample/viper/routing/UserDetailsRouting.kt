package com.mateuszkoslacz.moviper.rxsample.viper.routing

import com.mateuszkoslacz.moviper.base.routing.BaseViewHelperRxRouting
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.FullscreenPhotoActivity

class UserDetailsRouting : BaseViewHelperRxRouting<UserDetailsContract.ViewHelper>(), UserDetailsContract.Routing {

    override fun startFullscreenPhotoActivity(photoUrl: String) {
        if (isViewHelperAttached) {
            FullscreenPhotoActivity.start(activity!!, photoUrl,
                    viewHelper!!.avatarImageView)
        }
    }
}