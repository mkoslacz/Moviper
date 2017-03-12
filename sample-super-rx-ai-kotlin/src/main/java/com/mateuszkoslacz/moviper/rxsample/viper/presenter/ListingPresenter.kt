package com.mateuszkoslacz.moviper.rxsample.viper.presenter

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting

import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

open class ListingPresenter :
        BaseRxPresenter<ListingContract.View, ListingContract.Interactor, ListingContract.Routing>(),
        ViperPresenter<ListingContract.View> {

    override fun attachView(view: ListingContract.View) {
        super.attachView(view)
        getView()?.showLoading()

        addSubscription(interactor.userList
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            getView()?.setUserList(it)
                            getView()?.showContent()
                        },
                        { getView()?.showError(it) }))

        addSubscription(getView()?.userClicks?.subscribe { routing.startUserDetailsActivity(it) })
    }

    override fun createRouting(): ListingContract.Routing = ListingRouting()

    override fun createInteractor(): ListingContract.Interactor = ListingInteractor()
}
