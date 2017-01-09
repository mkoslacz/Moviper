package com.mateuszkoslacz.moviper.rxsample.viper.presenter

import android.os.Bundle

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.rxsample.viper.contract.FullscreenPhotoContract
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.FullscreenPhotoInteractor
import com.mateuszkoslacz.moviper.rxsample.viper.routing.FullscreenPhotoRouting
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.FullscreenPhotoActivity

class FullscreenPhotoPresenter(bundle: Bundle) :
        BaseRxPresenter<FullscreenPhotoContract.View,
                FullscreenPhotoContract.Interactor,
                FullscreenPhotoContract.Routing>(bundle),
        FullscreenPhotoContract.Presenter {

    private val mPhotoUrl: String = args.getString(FullscreenPhotoActivity.PHOTO_URL_EXTRA_STRING)

    override fun attachView(view: FullscreenPhotoContract.View) {
        super.attachView(view)
        getView()?.setPhoto(mPhotoUrl)
    }

    override fun createRouting(): FullscreenPhotoContract.Routing = FullscreenPhotoRouting()

    override fun createInteractor(): FullscreenPhotoContract.Interactor = FullscreenPhotoInteractor()
}
