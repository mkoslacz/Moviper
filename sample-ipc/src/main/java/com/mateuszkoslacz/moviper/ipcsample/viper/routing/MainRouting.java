package com.mateuszkoslacz.moviper.ipcsample.viper.routing;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;

public class MainRouting
        extends BaseRxRouting<Activity>
        implements MainContract.Routing {

    @Override
    public void createAndAddWidgetToSlotWithGivenId(String widgetName, int widgetColor,
                                                    int destinationSlotId) {
        bindWidgetToView(destinationSlotId, ColorWidgetFragment.create(widgetName, widgetColor));
    }

    public void bindWidgetToView(int destinationSlotId, Fragment fragment) {
        ((AppCompatActivity) getRelatedContext()).getSupportFragmentManager()
                .beginTransaction()
                .add(destinationSlotId, fragment)
                .commit();
    }
}
