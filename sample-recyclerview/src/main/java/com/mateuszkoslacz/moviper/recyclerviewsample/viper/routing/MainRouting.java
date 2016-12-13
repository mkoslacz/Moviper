package com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;

public class MainRouting
        extends BaseRxRouting
        implements MainContract.Routing {

    public MainRouting(@NonNull Activity activity) {
        super(activity);
    }
}
