package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRouting;
import com.mateuszkoslacz.moviper.sample.viper.contract.MainContract;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 */
public class MainRouting
        extends ActivityBaseViewHelperRouting<
        MainContract.PresenterForRouting,
        MainContract.ViewHelper>
        implements MainContract.Routing {

    public MainRouting(@NonNull Activity activity) {
        super(activity);
    }
}
