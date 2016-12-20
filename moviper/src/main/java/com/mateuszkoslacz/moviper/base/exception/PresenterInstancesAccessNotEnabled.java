package com.mateuszkoslacz.moviper.base.exception;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

public class PresenterInstancesAccessNotEnabled extends RuntimeException {

    public PresenterInstancesAccessNotEnabled() {
        super("You can't call getPresenterInstance() without explicitly enabling presenter " +
                "instances access! Instantiate Moviper in Application class using " +
                "Moviper.getInstance().setConfig(new Config.Builder()...) and setting " +
                "withInstancePresentersEnabled(true) in config builder.");
    }
}
