package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p/>
 * It's a Rx version of {@link BaseRouting}
 * <p/>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * <p/>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * <p/>
 * In complex use cases you will probably want to include here separate classes for handling alarms
 * scheduling, Services creating etc. for better separation of concepts.
 * <p/>
 * If you are looking for solution providing Android Views to use in Android Transaction with shared
 * views, see {@link BaseViewHelperRxRouting}
 */
public abstract class BaseRxRouting implements ViperRxRouting {

    @Nullable
    WeakReference<Activity> activity;

    @Nullable
    @Override
    public Activity getActivity() {
        return WeakReferenceUtils.get(activity);
    }

    @Override
    public boolean isActivityAttached() {
        return WeakReferenceUtils.isAttached(activity);
    }

    @Override
    public void attach(ActivityHolder activityHolder) {
        this.activity = new WeakReference<>(activityHolder.getActivity());
    }

    @Override
    public void detach(boolean retainInstance) {
        WeakReferenceUtils.detach(activity);
    }
}
