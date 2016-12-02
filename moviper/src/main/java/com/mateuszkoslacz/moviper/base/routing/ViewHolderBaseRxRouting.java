package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by jjodelka on 01/12/2016.
 */

public class ViewHolderBaseRxRouting
        extends ActivityBaseRxRouting
        implements MoviperRxRouting {

    @Nullable
    private WeakReference<Activity> activity;

    public ViewHolderBaseRxRouting(@NonNull Activity activity) {
        super(activity);
        this.activity = new WeakReference<>(activity);
    }

    @Override
    public void onPresenterDetached(boolean retainInstance) {
        super.onPresenterDetached(retainInstance);
        WeakReferenceUtils.detach(activity);
    }
}
