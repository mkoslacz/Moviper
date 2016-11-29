package com.mateuszkoslacz.moviper.recyclerviewsample.viper.base;

import android.support.annotation.NonNull;
import android.view.View;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;

/**
 * Created by norbertbanaszek on 26.10.2016.
 */

public interface MoviperViewHolderPresenterForRouting<RoutingType extends MoviperRouting>
        extends MoviperPresenterForRouting<RoutingType> {

    /**
     * Instantiate a Routing instance here.
     *
     * @return The {@link MoviperRouting} for this view
     */
    @NonNull
    RoutingType createRouting(@NonNull View view);
}
