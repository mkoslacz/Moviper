package com.mateuszkoslacz.moviper.rxsample.viper.contract

import android.app.Activity
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting

interface FullscreenPhotoContract {

    interface Presenter : MvpPresenter<View>

    interface View : MvpView {
        fun setPhoto(photoUrl: String)
    }

    interface Interactor : ViperRxInteractor

    interface Routing : ViperRxRouting<Activity>

}
