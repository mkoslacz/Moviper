package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.support.annotation.NonNull;
import android.app.Activity;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.Fullscreen_photoContract;

public class Fullscreen_photoRouting
        extends ActivityBaseViewHelperRxRouting<
        Fullscreen_photoContract.ViewHelper>
        implements Fullscreen_photoContract.Routing {

    public Fullscreen_photoRouting(@NonNull Activity activity) {
        super(activity);
    }
}
