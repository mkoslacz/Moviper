package com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductRouting
        extends ActivityBaseViewHelperRxRouting<
            MainContract.ViewHelper>
        implements MainContract.Routing {

    public ProductRouting(@NonNull Activity activity) {
        super(activity);
    }
}
