package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Activity version of base Routing class.
 * (see {@link ViperRouting} and {@link ViperPresenterForRouting})
 */
public class BaseRouting<PresenterType extends ViperPresenterForRouting>  // I prefer readability rather than conventions
        implements ViperRouting<PresenterType> {

    @Nullable
    private WeakReference<PresenterType> presenter;

    @Nullable
    WeakReference<Activity> activity;

    @Nullable
    @Override
    public PresenterType getPresenter() {
        return WeakReferenceUtils.get(presenter);
    }

    @Nullable
    @Override
    public Activity getActivity() {
        return WeakReferenceUtils.get(activity);
    }

    @Override
    public boolean isPresenterAttached() {
        return WeakReferenceUtils.isAttached(presenter);
    }

    @Override
    public boolean isActivityAttached() {
        return WeakReferenceUtils.isAttached(activity);
    }

    @Override
    public void attach(ViperView view, PresenterType presenter) {
        this.activity = new WeakReference<>(view.getActivity());
        this.presenter = new WeakReference<>(presenter);
    }

    @Override
    public void detach(boolean retainInstance) {
        WeakReferenceUtils.detach(presenter);
        WeakReferenceUtils.detach(activity);
    }

}
