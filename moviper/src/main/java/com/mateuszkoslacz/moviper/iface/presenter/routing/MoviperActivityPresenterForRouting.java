package com.mateuszkoslacz.moviper.iface.presenter.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * MoviperPresenterForRouting version for Activity presenters.
 * (see {@link MoviperPresenterForRouting})
 */
// I prefer readability rather than conventions
public interface MoviperActivityPresenterForRouting<RoutingType extends MoviperRxRouting>
        extends MoviperPresenterForRouting<RoutingType> {

    /**
     * Instantiate a Routing instance here.
     *
     * @return The {@link MoviperRouting} for this view
     */
    @NonNull
    RoutingType createRouting(@NonNull Activity activity);
}
