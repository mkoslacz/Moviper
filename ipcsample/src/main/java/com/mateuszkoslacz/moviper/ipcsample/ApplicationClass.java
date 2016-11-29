package com.mateuszkoslacz.moviper.ipcsample;

import android.app.Application;

import com.mateuszkoslacz.moviper.presenterbus.Config;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

/**
 * Created by jjodelka on 08/11/2016.
 */

public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Moviper.getInstance().setConfig(
                new Config.Builder()
                        .withPresenterAccessUtilEnabled(true) // plain IPC
                        .withInstancePresentersEnabled(true) // acces to specific presenters
                        .build());
    }
}
