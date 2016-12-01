package com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import com.mateuszkoslacz.moviper.base.routing.ViewHolderBaseRxRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.HeaderContract;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderRouting
        extends ViewHolderBaseRxRouting
        implements HeaderContract.Routing {

    public HeaderRouting(@NonNull View view) {
        super((Activity) view.getContext());
    }
}
