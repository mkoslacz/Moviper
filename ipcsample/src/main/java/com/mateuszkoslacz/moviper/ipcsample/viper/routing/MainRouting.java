package com.mateuszkoslacz.moviper.ipcsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.MainContract;

public class MainRouting
        extends ActivityBaseRxRouting
        implements MainContract.Routing {

    public MainRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void bindFragmentToView(int viewId, Fragment fragment) {
        ((AppCompatActivity) getActivity()).getSupportFragmentManager()
                .beginTransaction()
                .add(viewId, fragment)
                .commit();
    }
}
