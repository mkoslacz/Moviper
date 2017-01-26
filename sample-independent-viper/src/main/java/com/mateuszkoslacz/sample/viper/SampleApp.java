package com.mateuszkoslacz.sample.viper;

import android.app.Application;

import com.mateuszkoslacz.moviper.presenterbus.Config;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;
import com.mateuszkoslacz.sample.viper.contract.IndependentContract;

public class SampleApp
        extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Moviper.getInstance().setConfig(
                Config.newBuilder()
                        .withInstancePresentersEnabled(true)
                        .withPresenterAccessUtilEnabled(true)
                        .build());
    }
}
