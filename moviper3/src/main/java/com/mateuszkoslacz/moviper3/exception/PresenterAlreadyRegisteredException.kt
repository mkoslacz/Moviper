package com.mateuszkoslacz.moviper3.exception

import com.mateuszkoslacz.moviper3.iface.presenter.ViperPresenter

/**
 * Created by mateuszkoslacz on 24.10.2016.
 *
 *
 * Thrown when you have IPC Presenter Instance Access enabled and you try to create new Presenter
 * with name that is already registered for its class. To avoid that you have to implement [ ][ViperPresenter.getName] in the way that returns an unique name for each instance of presenter
 * of given class.
 */
class PresenterAlreadyRegisteredException(presenter: ViperPresenter<*>)
    : RuntimeException(String.format(
        "Presenter %1\$s named %2\$s is already registered! You enabled presenter " +
                "instances access and tried to register two or more presenters of the " +
                "same class and name. Override getName() method in your %1\$s presenter " +
                "in way that will provide unique name for each instance or disable " +
                "presenter instances access using " +
                "Moviper.getInstance().setConfig(new Config.Builder()...) and setting " +
                "withInstancePresentersEnabled(true) in config builder.",
        presenter.javaClass.name,
        presenter.name))
