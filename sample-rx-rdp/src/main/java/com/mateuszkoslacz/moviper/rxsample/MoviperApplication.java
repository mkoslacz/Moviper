package com.mateuszkoslacz.moviper.rxsample;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.mateuszkoslacz.moviper.rxsample.di.DIProvider;

public class MoviperApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DIProvider.getInstance().init(getApplicationContext());
    }
}
