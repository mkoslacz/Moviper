package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends BaseRxRouting<Activity>
        implements ListingContract.Routing {

    @Override
    public void startUserDetailsActivity(User user) {
        if (isContextAttached()) UserDetailsActivity.start(getRelatedContext(), user);
    }
}