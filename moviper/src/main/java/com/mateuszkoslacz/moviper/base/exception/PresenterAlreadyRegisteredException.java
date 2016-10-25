package com.mateuszkoslacz.moviper.base.exception;

import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

public class PresenterAlreadyRegisteredException extends RuntimeException {

    public PresenterAlreadyRegisteredException(MoviperPresenter presenter) {
        super(String.format("Presenter %s named %s is already registered!",
                presenter.getClass().getName(), presenter.getName()));
    }
}
