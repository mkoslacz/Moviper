package com.mateuszkoslacz.moviper.ipcsample.viper.routing;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.base.routing.FragmentBaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ViperContract;

public class ViperRouting
        extends FragmentBaseViewHelperRxRouting<
        ViperContract.ViewHelper>
        implements ViperContract.Routing {

    public ViperRouting(@NonNull Fragment fragment) {
        super(fragment);
    }
}
