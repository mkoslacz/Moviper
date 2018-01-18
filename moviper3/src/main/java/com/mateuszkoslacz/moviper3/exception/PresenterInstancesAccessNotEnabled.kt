package com.mateuszkoslacz.moviper3.exception

import android.app.Application

import com.mateuszkoslacz.moviper3.presenterbus.Config
import com.mateuszkoslacz.moviper3.presenterbus.Moviper

/**
 * Created by mateuszkoslacz on 24.10.2016.
 *
 *
 * Thrown when you haven't enabled IPC Presenter Instance Access and you try to use it ([ ][Moviper.getPresenterInstance]. To avoid that configure Moviper using [ ][Moviper.setConfig] in [ ][Application.onCreate] with [Config.Builder.withInstancePresentersEnabled] set to
 * true.
 */
class PresenterInstancesAccessNotEnabled
    : RuntimeException("You can't call getPresenterInstance() without explicitly enabling presenter " +
        "instances access! Instantiate Moviper in Application class using " +
        "Moviper.getInstance().setConfig(new Config.Builder()...) and setting " +
        "withInstancePresentersEnabled(true) in config builder.")
