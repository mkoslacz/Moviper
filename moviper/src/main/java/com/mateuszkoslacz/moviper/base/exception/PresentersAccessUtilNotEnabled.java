package com.mateuszkoslacz.moviper.base.exception;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

public class PresentersAccessUtilNotEnabled extends RuntimeException {

    public PresentersAccessUtilNotEnabled() {
        super("You can't call getPresenters() without explicitly enabling presenter " +
                "presenter access util! Instantiate Moviper in Application class using " +
                "Moviper.getInstance().setConfig(new Config.Builder()...) and setting " +
                "withPresenterAccessUtilEnabled(true) in config builder.");
    }
}
