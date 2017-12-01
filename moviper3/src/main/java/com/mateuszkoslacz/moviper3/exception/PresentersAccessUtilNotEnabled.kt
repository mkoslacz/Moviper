package com.mateuszkoslacz.moviper3.exception

import android.app.Application

import com.mateuszkoslacz.moviper3.presenterbus.Config
import com.mateuszkoslacz.moviper3.presenterbus.Moviper

/**
 * Created by mateuszkoslacz on 24.10.2016.
 *
 *
 * Thrown when you haven't enabled IPC and you try to use it ([Moviper.getPresenters].
 * To avoid that configure Moviper using [Moviper.setConfig] in [ ][Application.onCreate] with [Config.Builder.withPresenterAccessUtilEnabled] set
 * to true.
 */

class PresentersAccessUtilNotEnabled : RuntimeException("You can't call getPresenters() without explicitly enabling presenter " +
        "presenter access util! Instantiate Moviper in Application class using " +
        "Moviper.getInstance().setConfig(new Config.Builder()...) and setting " +
        "withPresenterAccessUtilEnabled(true) in config builder.")
