package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends BaseRxRouting
        implements ListingContract.Routing {

    @Override
    public void startUserDetailsActivity(User user) {
        if (isActivityAttached()) UserDetailsActivity.start(getActivity(), user);
    }
}