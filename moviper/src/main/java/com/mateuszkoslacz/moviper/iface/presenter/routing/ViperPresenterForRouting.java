package com.mateuszkoslacz.moviper.iface.presenter.routing;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * It defines presenter interface which Routing ({@link ViperRouting}) needs to communicate with
 * Presenter ({@link com.hannesdorfmann.mosby.mvp.MvpBasePresenter}) for proper
 * execution of given tasks. There are mostly callbacks for creating alarms,
 * routing's error messages etc.
 */
// I prefer readability rather than conventions
public interface ViperPresenterForRouting<RoutingType extends ViperRxRouting> {

    /**
     * @return attached {@link ViperRouting} subclass instance or
     * null if it's detached (View got destroyed)
     */
    @NonNull
    RoutingType getRouting();

    /**
     * Instantiate a Routing instance here.
     *
     * @return The {@link ViperRouting} for this view
     */
    @NonNull
    RoutingType createRouting();
}
