package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends BaseRxRouting
        implements ListingContract.Routing {

    public ListingRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void startUserDetailsActivity(User user) {
        if (isActivityAttached()) UserDetailsActivity.start(getActivity(), user);
    }
}