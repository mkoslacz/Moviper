package com.mateuszkoslacz.moviper3.exception

import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter

/**
 * Created by mateuszkoslacz on 24.10.2016.
 *
 *
 * Thrown when IPC couldn't find the presenter you requested.
 */

class PresenterNotFoundException(presenterType: Class<*>,
                                 presenterName: String)
    : RuntimeException("Presenter $presenterType named $presenterName not found! Make sure it's registered.")