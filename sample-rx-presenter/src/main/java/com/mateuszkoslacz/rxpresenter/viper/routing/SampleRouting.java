package com.mateuszkoslacz.rxpresenter.viper.routing;

import android.support.annotation.NonNull;
import android.app.Activity;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.rxpresenter.viper.contract.SampleContract;

public class SampleRouting
        extends BaseRxRouting
        implements SampleContract.Routing {

    public SampleRouting(@NonNull Activity activity) {
        super(activity);
    }
}
