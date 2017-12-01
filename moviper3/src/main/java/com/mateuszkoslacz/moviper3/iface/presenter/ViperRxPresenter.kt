package com.mateuszkoslacz.moviper3.iface.presenter

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper3.iface.routing.ViperRxRouting

/**
 * Created by mateuszkoslacz on 24.10.2016.
 *
 *
 * Base interface for VIPER presenter.
 */

interface ViperRxPresenter<ViewType : MvpView,
        out InteractorType : ViperRxInteractor,
        out RoutingType : ViperRxRouting<*>>: MvpPresenter<ViewType> {

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

    /**
     * @return attached ViperRouting
     */
    val routing: RoutingType

    /**
     * Override this and return a instantiated Routing object here.
     *
     * @return The ViperRouting for this view
     */
    fun createRouting(): RoutingType

    /**
     * @return attached ViperInteractor.
     */
    val interactor: InteractorType

    /**
     * Override this and return a instantiated Interactor object here.
     *
     * @return The ViperInteractor for this view
     */
    fun createInteractor(): InteractorType
}
