package com.mateuszkoslacz.moviper.ipcsample.viper.routing;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ColorWidgetContract;

public class ColorWidgetRouting
        extends BaseRxRouting
        implements ColorWidgetContract.Routing, MoviperRxRouting {

    public ColorWidgetRouting(@NonNull Fragment fragment) {
        super(fragment.getActivity());
    }
}
