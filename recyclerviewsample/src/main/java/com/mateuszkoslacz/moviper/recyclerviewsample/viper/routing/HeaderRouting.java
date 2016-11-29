package com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ViewHolderBaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.HeaderContract;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderRouting
        extends ViewHolderBaseViewHelperRxRouting<HeaderContract.ViewHelper>
        implements HeaderContract.Routing {

    public HeaderRouting(@NonNull Activity activity) {
        super(activity);
    }
}
