package com.mateuszkoslacz.moviper.rxsample.viper.contract

import android.app.Activity
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperViewHelperRxRouting
import com.mateuszkoslacz.moviper.iface.viewhelper.ViperViewHelper
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import io.reactivex.Observable

interface UserDetailsContract {

    interface View : MvpLceView<User> {
        fun bindDataToViews(user: User)

        val avatarClicks: Observable<String>
    }

    interface Interactor : ViperRxInteractor {
        fun getUserForUsername(user: String): Observable<User>
    }

    interface Routing : ViperViewHelperRxRouting<Activity, ViewHelper> {
        fun startFullscreenPhotoActivity(photoUrl: String)
    }

    interface ViewHelper : ViperViewHelper {
        val avatarImageView: android.view.View
    }
}
