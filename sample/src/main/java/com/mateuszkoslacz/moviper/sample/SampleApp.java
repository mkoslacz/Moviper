package com.mateuszkoslacz.moviper.sample;

import android.app.Application;

import com.mateuszkoslacz.moviper.sample.data.parse.util.ParseInitializator;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by mateuszkoslacz on 12.08.2016.
 */
public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseInitializator.init(this);
        LeakCanary.install(this); // to ensure that Moviper does not introduce any leaks
    }
}
