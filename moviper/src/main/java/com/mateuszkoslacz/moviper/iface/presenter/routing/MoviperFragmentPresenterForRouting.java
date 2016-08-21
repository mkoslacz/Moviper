package com.mateuszkoslacz.moviper.iface.presenter.routing;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * MoviperPresenterForRouting version for Fragment presenters.
 * (see {@link MoviperPresenterForRouting})
 */
// I prefer readability rather than conventions
public interface MoviperFragmentPresenterForRouting<RoutingType extends MoviperRouting>
        extends MoviperPresenterForRouting<RoutingType> {

    /**
     * Instantiate a Routing instance here.
     *
     * @return The {@link MoviperRouting} for this view
     */
    @NonNull
    RoutingType createRouting(@NonNull Fragment fragment);
}
