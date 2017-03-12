package com.mateuszkoslacz.moviper.iface.presenter.routing;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.routing.CommonViperRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Interface used by Routing ({@link ViperRouting}) to communicate with Presenter ({@link
 * ViperPresenter}). There are mostly callbacks for creating alarms, routing's error messages etc.
 */
public interface ViperPresenterForRouting<RoutingType extends CommonViperRouting> {

    /**
     * @return attached {@link ViperRouting}
     */
    @NonNull
    RoutingType getRouting();

    /**
     * Override this and return a instantiated Routing object here.
     *
     * @return The {@link ViperRouting} for this view
     */
    @NonNull
    RoutingType createRouting();
}
