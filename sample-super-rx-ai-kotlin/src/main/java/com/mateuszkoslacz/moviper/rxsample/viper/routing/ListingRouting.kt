package com.mateuszkoslacz.moviper.rxsample.viper.routing

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.UserDetailsPresenter
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity
import com.mateuszkoslacz.moviper.server.ActivityStarter
import com.mateuszkoslacz.moviper.server.MoviperPresentersDispatcher

open class ListingRouting : BaseRxRouting(), ListingContract.Routing {

    override fun startUserDetailsActivity(user: User) {
        if (isActivityAttached) {
            val startingIntent = UserDetailsActivity.getStartingIntent(activity!!, user)
            MoviperPresentersDispatcher.getInstance().startActivity(
                    ActivityStarter.newBuilder()
                            .withContext(activity!!)
                            .withIntent(startingIntent)
                            .withPresenter(UserDetailsPresenter(startingIntent.extras))
                            .build())
        }
    }
}
