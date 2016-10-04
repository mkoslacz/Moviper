package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Activity version of base Routing class.
 * (see {@link MoviperRouting} and {@link MoviperPresenterForRouting})
 */
public abstract class ActivityBaseRxRouting
        implements MoviperRxRouting {

    @NonNull
    protected WeakReference<Activity> activity;

    public ActivityBaseRxRouting(@NonNull Activity activity) {
        this.activity = new WeakReference<>(activity);
    }

    @Override
    public boolean isActivityAttached() {
        return WeakReferenceUtils.isAttached(activity);
    }

    @Nullable
    @Override
    public Activity getActivity() {
        return WeakReferenceUtils.get(activity);
    }
}
