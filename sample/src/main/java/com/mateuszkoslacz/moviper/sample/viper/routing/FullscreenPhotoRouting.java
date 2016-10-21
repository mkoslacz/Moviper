package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRouting;
import com.mateuszkoslacz.moviper.sample.viper.contract.FullscreenPhotoContract;

public class FullscreenPhotoRouting
        extends ActivityBaseViewHelperRouting<
        FullscreenPhotoContract.PresenterForRouting,
        FullscreenPhotoContract.ViewHelper>
        implements FullscreenPhotoContract.Routing {

    public FullscreenPhotoRouting(@NonNull Activity activity) {
        super(activity);
    }
}
