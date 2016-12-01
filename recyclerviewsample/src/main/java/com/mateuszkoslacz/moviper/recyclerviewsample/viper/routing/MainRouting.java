package com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;

public class MainRouting
        extends ActivityBaseViewHelperRxRouting<MainContract.ViewHelper>
        implements MainContract.Routing {

    public MainRouting(@NonNull Activity activity) {
        super(activity);
    }
}
