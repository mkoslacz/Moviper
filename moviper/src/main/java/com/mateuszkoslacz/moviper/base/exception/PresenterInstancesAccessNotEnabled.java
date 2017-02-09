package com.mateuszkoslacz.moviper.base.exception;

import android.app.Application;

import com.mateuszkoslacz.moviper.presenterbus.Config;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 * <p>
 * Thrown when you haven't enabled IPC Presenter Instance Access and you try to use it ({@link
 * Moviper#getPresenterInstance(Class, String)}. To avoid that configure Moviper using {@link
 * com.mateuszkoslacz.moviper.presenterbus.Moviper#setConfig(Config)} in {@link
 * Application#onCreate()} with {@link Config.Builder#withInstancePresentersEnabled(boolean)} set to
 * true.
 */


public class PresenterInstancesAccessNotEnabled extends RuntimeException {

    public PresenterInstancesAccessNotEnabled() {
        super("You can't call getPresenterInstance() without explicitly enabling presenter " +
                "instances access! Instantiate Moviper in Application class using " +
                "Moviper.getInstance().setConfig(new Config.Builder()...) and setting " +
                "withInstancePresentersEnabled(true) in config builder.");
    }
}
