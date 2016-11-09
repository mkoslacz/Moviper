package com.mateuszkoslacz.moviper.iface.presenter.routing;

import android.support.annotation.NonNull;
import android.view.View;

import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;

/**
 * Created by norbertbanaszek on 09.11.2016.
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
