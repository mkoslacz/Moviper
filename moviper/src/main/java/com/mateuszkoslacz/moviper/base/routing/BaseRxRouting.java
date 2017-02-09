package com.mateuszkoslacz.moviper.base.routing;

import android.content.Context;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ContextHolder;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * It's a Rx version of {@link BaseRouting}
 * <p>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * <p>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * <p>
 * In complex use cases you will probably want to include here separate classes for handling alarms
 * scheduling, Services creating etc. for better separation of concepts.
 * <p>
 * If you are looking for solution providing Android Views to use in Android Transaction with
 * shared
 * views, see {@link BaseViewHelperRxRouting}
 */
public abstract class BaseRxRouting<RelatedContext extends Context>
        implements ViperRxRouting<RelatedContext> {

    @Nullable
    WeakReference<RelatedContext> context;

    @Nullable
    @Override
    public RelatedContext getRelatedContext() {
        return WeakReferenceUtils.get(context);
    }

    @Override
    public boolean isContextAttached() {
        return WeakReferenceUtils.isAttached(context);
    }

    @Override
    public void attach(ContextHolder contextHolder) {
        this.context = new WeakReference<>((RelatedContext) contextHolder.getContext());
    }

    @Override
    public void detach(boolean retainInstance) {
        WeakReferenceUtils.detach(context);
    }
}
