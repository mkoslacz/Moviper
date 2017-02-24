package com.mateuszkoslacz.moviper.iface.presenter;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.CommonViperInteractor;
import com.mateuszkoslacz.moviper.iface.routing.CommonViperRouting;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 * <p/>
 * Base interface for VIPER presenter.
 */

public interface ViperPresenter
        <View extends MvpView,
                InteractorType extends CommonViperInteractor,
                RoutingType extends CommonViperRouting>
        extends MvpPresenter<View> {

    String DEFAULT_NAME = "default";

    /**
     * Override this if you want to access your presenter using IPC Instance Presenters Access
     * {@link Moviper#getPresenterInstance}.
     * <p/>
     * If you create two presenters with the same name (not assuring that this method will return an
     * unique name for each presenter) with the IPC Instance Presenters Access enabled, a {@link
     * PresenterAlreadyRegisteredException} is thrown.
     *
     * @return name of this presenter. Default {@link ViperPresenter#DEFAULT_NAME}
     */
    String getName();

    /**
     * @return attached {@link ViperInteractor}.
     */
    @NonNull
    InteractorType getInteractor();

    /**
     * Override this and return a instantiated Interactor object here.
     *
     * @return The {@link ViperInteractor} for this view
     */
    @NonNull
    InteractorType createInteractor();

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
