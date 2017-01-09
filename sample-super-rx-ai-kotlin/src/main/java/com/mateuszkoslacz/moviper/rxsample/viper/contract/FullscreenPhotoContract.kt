package com.mateuszkoslacz.moviper.rxsample.viper.contract

import com.hannesdorfmann.mosby.mvp.MvpPresenter
import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting

interface FullscreenPhotoContract {

    interface Presenter : MvpPresenter<View>

    interface View : MvpView {
        fun setPhoto(photoUrl: String)
    }

    interface Interactor : ViperRxInteractor

    interface Routing : ViperRxRouting
}
