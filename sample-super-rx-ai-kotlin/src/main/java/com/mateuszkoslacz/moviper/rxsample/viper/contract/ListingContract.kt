package com.mateuszkoslacz.moviper.rxsample.viper.contract

import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import rx.Observable

interface ListingContract {

    interface View : MvpView {
        val userClicks: Observable<User>

        fun setUserList(userList: List<User>)

        fun showError(throwable: Throwable)

        fun showLoading()

        fun showContent()
    }

    interface Interactor : ViperRxInteractor {
        val userList: Observable<List<User>>
    }

    interface Routing : ViperRxRouting {
        fun startUserDetailsActivity(user: User)
    }
}
