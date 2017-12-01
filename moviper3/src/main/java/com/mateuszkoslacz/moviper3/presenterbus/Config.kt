package com.mateuszkoslacz.moviper3.presenterbus

/**
 * Created by mateuszkoslacz on 29.10.2016.
 *
 * Pass it to [Moviper.setConfig] to enable IPC and IPC Presenter Instance Access in
 * app.
 */
class Config(val isPresenterAccessUtilEnabled: Boolean = false,
             val isInstancePresentersEnabled: Boolean = false)