package com.mateuszkoslacz.moviper.base.exception;

import android.app.Application;

import com.mateuszkoslacz.moviper.presenterbus.Config;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 * <p>
 * Thrown when you haven't enabled IPC and you try to use it ({@link Moviper#getPresenters(Class)}.
 * To avoid that configure Moviper using {@link Moviper#setConfig(Config)} in {@link
 * Application#onCreate()} with {@link Config.Builder#withPresenterAccessUtilEnabled(boolean)} set
 * to true.
 */

public class PresentersAccessUtilNotEnabled extends RuntimeException {

    public PresentersAccessUtilNotEnabled() {
        super("You can't call getPresenters() without explicitly enabling presenter " +
                "presenter access util! Instantiate Moviper in Application class using " +
                "Moviper.getInstance().setConfig(new Config.Builder()...) and setting " +
                "withPresenterAccessUtilEnabled(true) in config builder.");
    }
}
