package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.support.annotation.NonNull;
import android.app.Activity;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;

public class ListingRouting
        extends ActivityBaseRxRouting
        implements ListingContract.Routing {

    public ListingRouting(@NonNull Activity activity) {
        super(activity);
    }
}
