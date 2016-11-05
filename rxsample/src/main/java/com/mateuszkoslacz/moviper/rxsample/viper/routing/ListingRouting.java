package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.data.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends ActivityBaseRxRouting
        implements ListingContract.Routing {

    public ListingRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void startUserDetailsActivity(User user) {
        if (isActivityAttached()) UserDetailsActivity.start(getActivity(), user);
    }
}