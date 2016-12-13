package com.mateuszkoslacz.moviper.rxsample;

import android.app.Application;

import com.mateuszkoslacz.moviper.rxsample.di.DIProvider;

public class MoviperApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DIProvider.init(getApplicationContext());
    }
}
