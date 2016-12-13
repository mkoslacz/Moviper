package com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;

public class MainRouting
        extends ActivityBaseRxRouting
        implements MainContract.Routing {

    public MainRouting(@NonNull Activity activity) {
        super(activity);
    }
}
