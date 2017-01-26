package com.mateuszkoslacz.moviper.rxsample.viper.routing

import android.app.Activity
import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.UserDetailsPresenter
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity
import com.mateuszkoslacz.moviper.presentersdispatcher.ActivityStarter
import com.mateuszkoslacz.moviper.presentersdispatcher.MoviperPresentersDispatcher

open class ListingRouting : BaseRxRouting<Activity>(), ListingContract.Routing {

    override fun startUserDetailsActivity(user: User) {
        if (isContextAttached) {
            val startingIntent = UserDetailsActivity.getStartingIntent(relatedContext!!, user)
            MoviperPresentersDispatcher.getInstance().startActivity(
                    ActivityStarter.newBuilder()
                            .withContext(relatedContext!!)
                            .withIntent(startingIntent)
                            .withPresenter(UserDetailsPresenter(startingIntent.extras))
                            .build())
        }
    }
}
