package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p/>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * <p/>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * <p/>
 * If you are looking for solution providing Android Views to use in Android Transaction with shared
 * views, see {@link BaseViewHelperRouting}. If you are looking for solution adopted to Rx approach,
 * see {@link BaseRxRouting}. If both, see {@link BaseViewHelperRxRouting}.
 */
public class BaseRouting<PresenterType extends ViperPresenterForRouting>  // I prefer readability rather than conventions
        implements ViperRouting<PresenterType> {

    @Nullable
    WeakReference<Activity> activity;
    @Nullable
    private WeakReference<PresenterType> presenter;

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
    public void attach(ActivityHolder activityHolder, PresenterType presenter) {
        this.activity = new WeakReference<>(activityHolder.getActivity());
        this.presenter = new WeakReference<>(presenter);
    }

    @Override
    public void detach(boolean retainInstance) {
        WeakReferenceUtils.detach(presenter);
        WeakReferenceUtils.detach(activity);
    }

}
