package com.mateuszkoslacz.moviper.ipcsample.viper.routing;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.presenter.ColorWidgetPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;

public class MainRouting
        extends ActivityBaseRxRouting
        implements MainContract.Routing {

    public MainRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void prepareAndBindWidgetToView(String widgetName, String colorName,
                                           String color, int viewId) {
        ColorWidgetFragment colorWidgetFragment = new ColorWidgetFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ColorWidgetPresenter.FRAGMENT_PRESENTER_NAME, widgetName);
        bundle.putString(ColorWidgetPresenter.FRAGMENT_COLOR_NAME, colorName);
        bundle.putString(ColorWidgetPresenter.FRAGMENT_BACKGROUND_COLOR, color);
        colorWidgetFragment.setArguments(bundle);
        bindWidgetToView(viewId, colorWidgetFragment);
    }

    public void bindWidgetToView(int viewId, Fragment fragment) {
        ((AppCompatActivity) getActivity()).getSupportFragmentManager()
                .beginTransaction()
                .add(viewId, fragment)
                .commit();
    }
}
