package com.mateuszkoslacz.moviper.ipcsample.viper.routing;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.base.routing.FragmentBaseRxRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ColorWidgetContract;

public class ColorWidgetRouting
        extends FragmentBaseRxRouting
        implements ColorWidgetContract.Routing {

    public ColorWidgetRouting(@NonNull Fragment fragment) {
        super(fragment);
    }
}
