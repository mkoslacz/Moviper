package com.mateuszkoslacz.moviper.base.routing;

import android.content.Context;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.iface.view.ContextHolder;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * <p>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * <p>
 * If you are looking for solution providing Android Views to use in Android Transaction with
 * shared
 * views, see {@link BaseViewHelperRouting}. If you are looking for solution adopted to Rx
 * approach,
 * see BaseRxRouting. If both, see BaseViewHelperRxRouting.
 */
public abstract class BaseRouting
        <RelatedContext extends Context,
                PresenterType extends ViperPresenterForRouting>
        implements ViperRouting<RelatedContext, PresenterType> {

    @Nullable
    WeakReference<RelatedContext> context;
    @Nullable
    private WeakReference<PresenterType> presenter;

    @Nullable
    @Override
    public PresenterType getPresenter() {
        return WeakReferenceUtils.get(presenter);
    }

    @Override
    public boolean isPresenterAttached() {
        return WeakReferenceUtils.isAttached(presenter);
    }

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
    public void attach(ContextHolder contextHolder, PresenterType presenter) {
        this.context = new WeakReference<>((RelatedContext) contextHolder.getContext());
        this.presenter = new WeakReference<>(presenter);
    }

    @Override
    public void detach(boolean retainInstance) {
        WeakReferenceUtils.detach(presenter);
        WeakReferenceUtils.detach(context);
    }

}
