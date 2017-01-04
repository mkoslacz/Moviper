package com.mateuszkoslacz.moviper.iface.presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.exception.PresenterAlreadyRegisteredException;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 * <p/>
 * Base interface for VIPER presenter.
 */

public interface ViperPresenter<View extends MvpView> extends MvpPresenter<View> {

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
}
