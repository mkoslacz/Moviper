package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Activity version of base Routing class.
 * (see {@link ViperRouting} and {@link ViperPresenterForRouting})
 */
public abstract class BaseRxRouting
        implements ViperRxRouting {

    @NonNull
    WeakReference<Activity> activity;

    @Override
    public boolean isActivityAttached() {
        return WeakReferenceUtils.isAttached(activity);
    }

    @Override
    public void attachActivity(ViperView view) {
        activity = new WeakReference<>(view.getActivity());
    }

    @Override
    public void detachActivity() {
        WeakReferenceUtils.detach(activity);
    }

    @Nullable
    @Override
    public Activity getActivity() {
        return WeakReferenceUtils.get(activity);
    }

    @Override
    public void onPresenterDetached(boolean retainInstance) {
        onPresenterDetached();
        // stub
    }

    @Override
    @Deprecated
    public void onPresenterDetached() {
        // stub
    }
}
