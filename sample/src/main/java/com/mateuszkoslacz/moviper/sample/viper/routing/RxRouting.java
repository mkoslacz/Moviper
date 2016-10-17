package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;
import com.mateuszkoslacz.moviper.sample.viper.contract.RxContract;

public class RxRouting
        extends ActivityBaseRxRouting
        implements RxContract.Routing {

    public RxRouting(@NonNull Activity activity) {
        super(activity);
    }
}
