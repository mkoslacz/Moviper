package com.mateuszkoslacz.moviper.iface.presenter.routing;

import android.support.annotation.NonNull;
import android.view.View;

import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

/**
 * Created by jjodelka on 29/11/2016.
 * <p>
 * MoviperPresenterForRouting version for ViewHolder presenters.
 * (see {@link MoviperPresenterForRouting})
 */

public interface MoviperViewHolderRxPresenterForRouting<RoutingType extends MoviperRxRouting>
        extends MoviperPresenterForRouting<RoutingType> {

    /**
     * Instantiate a Routing instance here.
     *
     * @return The {@link MoviperRouting} for this view
     */
    @NonNull
    RoutingType createRouting(@NonNull View view);
}
