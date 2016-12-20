package com.mateuszkoslacz.moviper.iface.presenter.routing;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.routing.CommonViperRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * It defines presenter interface which Routing ({@link ViperRouting}) needs to communicate with
 * Presenter ({@link ViperPresenter}) for proper execution of given tasks. There are mostly
 * callbacks for creating alarms, routing's error messages etc.
 */
public interface ViperPresenterForRouting<RoutingType extends CommonViperRouting> {

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
