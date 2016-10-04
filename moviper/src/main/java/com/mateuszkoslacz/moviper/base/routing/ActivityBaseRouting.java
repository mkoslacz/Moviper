package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Activity version of base Routing class.
 * (see {@link MoviperRouting} and {@link MoviperPresenterForRouting})
 */
public abstract class ActivityBaseRouting
        <PresenterType extends MoviperPresenterForRouting>  // I prefer readability rather than conventions
        implements MoviperRouting<PresenterType> {

    @NonNull
    protected WeakReference<Activity> activity;

    @Nullable
    private WeakReference<PresenterType> presenter;

    public ActivityBaseRouting(@NonNull Activity activity) {
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

    @Override
    public void attachPresenter(PresenterType presenter) {
        this.presenter = new WeakReference<>(presenter);
    }

    @Nullable
    @Override
    public PresenterType getPresenter() {
        return WeakReferenceUtils.get(presenter);
    }

    @Override
    public boolean isPresenterAttached() {
        return WeakReferenceUtils.isAttached(presenter);
    }

    @Override
    public void detachPresenter() {
        WeakReferenceUtils.detach(presenter);
        WeakReferenceUtils.detach(activity);
    }

}
