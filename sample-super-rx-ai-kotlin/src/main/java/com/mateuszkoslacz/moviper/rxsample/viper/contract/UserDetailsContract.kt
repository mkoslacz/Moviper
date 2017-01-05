package com.mateuszkoslacz.moviper.rxsample.viper.contract

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperViewHelperRxRouting
import com.mateuszkoslacz.moviper.iface.viewhelper.ViperViewHelper
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import rx.Observable

interface UserDetailsContract {

    interface View : MvpLceView<User> {
        fun bindDataToViews(user: User)

        val avatarClicks: Observable<String>
    }

    interface Interactor : ViperRxInteractor {
        fun getUserForUsername(user: String): Observable<User>
    }

    interface Routing : ViperViewHelperRxRouting<ViewHelper> {
        fun startFullscreenPhotoActivity(photoUrl: String)
    }

    interface ViewHelper : ViperViewHelper {
        val avatarImageView: android.view.View
    }
}
