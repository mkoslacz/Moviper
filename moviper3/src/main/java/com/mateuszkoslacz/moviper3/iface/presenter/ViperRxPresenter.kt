package com.mateuszkoslacz.moviper3.iface.presenter

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created by mateuszkoslacz on 24.10.2016.
 *
 *
 * Base interface for VIPER presenter.
 */

interface ViperRxPresenter<ViewType : MvpView>: MvpPresenter<ViewType> {

    /**
     * Override this if you want to access your presenter using IPC Instance Presenters Access
     * Moviper#getPresenterInstance.
     *
     *
     * If you create two presenters with the same name (not assuring that this method will return an
     * unique name for each presenter) with the IPC Instance Presenters Access enabled, a
     * PresenterAlreadyRegisteredException is thrown.
     *
     * @return name of this presenter. Default is a "$className()_$randomInt"
     */
    val name: String
}
