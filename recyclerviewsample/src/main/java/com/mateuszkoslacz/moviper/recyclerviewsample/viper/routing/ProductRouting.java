package com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ViewHolderBaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.ProductContract;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductRouting
        extends ViewHolderBaseViewHelperRxRouting<ProductContract.ViewHelper>
        implements ProductContract.Routing {

    public ProductRouting(@NonNull Activity activity) {
        super(activity);
    }
}
