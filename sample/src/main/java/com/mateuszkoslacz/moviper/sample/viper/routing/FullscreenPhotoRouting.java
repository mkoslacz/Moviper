package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.BaseRouting;
import com.mateuszkoslacz.moviper.sample.viper.contract.FullscreenPhotoContract;

public class FullscreenPhotoRouting
        extends BaseRouting<FullscreenPhotoContract.PresenterForRouting>
        implements FullscreenPhotoContract.Routing {

    public FullscreenPhotoRouting(@NonNull Activity activity) {
        super(activity);
    }
}
