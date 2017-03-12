package com.mateuszkoslacz.moviper.rxsample.viper.presenter

import android.os.Bundle

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.UserDetailsInteractor
import com.mateuszkoslacz.moviper.rxsample.viper.routing.UserDetailsRouting
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity

import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class UserDetailsPresenter(bundle: Bundle) :
        BaseRxPresenter<UserDetailsContract.View,
                UserDetailsContract.Interactor,
                UserDetailsContract.Routing>(bundle),
        ViperPresenter<UserDetailsContract.View> {

    override fun attachView(view: UserDetailsContract.View) {
        super.attachView(view)
        getView()?.showLoading(false)
        getUserDataFromApi(args.getString(UserDetailsActivity.USER_EXTRA))
        addSubscription(getView()?.avatarClicks?.subscribe(
                { routing.startFullscreenPhotoActivity(it) }))
    }

    private fun getUserDataFromApi(userLogin: String) {
        interactor.getUserForUsername(userLogin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view?.setData(it)
                            view?.showContent()
                        },
                        { view?.showError(it, false) })
    }

    override fun createRouting(): UserDetailsContract.Routing = UserDetailsRouting()

    override fun createInteractor(): UserDetailsContract.Interactor = UserDetailsInteractor()
}
