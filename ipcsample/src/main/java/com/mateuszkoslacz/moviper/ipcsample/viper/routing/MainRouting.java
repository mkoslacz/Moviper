package com.mateuszkoslacz.moviper.ipcsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;

public class MainRouting
        extends ActivityBaseRxRouting
        implements MainContract.Routing {

    public MainRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void createAndAddWidgetToSlotWithGivenId(String colorName, String color, int viewId) {
        bindWidgetToView(viewId, ColorWidgetFragment.create(colorName, color));
    }

    public void bindWidgetToView(int viewId, Fragment fragment) {
        ((AppCompatActivity) getActivity()).getSupportFragmentManager()
                .beginTransaction()
                .add(viewId, fragment)
                .commit();
    }
}
