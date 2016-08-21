package com.mateuszkoslacz.moviper.iface.presenter.routing;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * It defines presenter interface which Routing ({@link MoviperRouting}) needs to communicate with
 * Presenter ({@link com.hannesdorfmann.mosby.mvp.MvpBasePresenter}) for proper
 * execution of given tasks. There are mostly callbacks for creating alarms,
 * routing's error messages etc.
 */
// I prefer readability rather than conventions
public interface MoviperPresenterForRouting<RoutingType extends MoviperRouting> {

    boolean isRoutingAttached();

    /**
     * Remember to call {@link #isRoutingAttached()} before getting the Routing to avoid
     * {@link NullPointerException}s.
     *
     * @return attached {@link MoviperRouting} subclass instance or
     * null if it's detached (View got destroyed)
     */
    @Nullable
    RoutingType getRouting();
}
