package com.mateuszkoslacz.moviper.base.routing;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Activity version of base Routing class.
 * (see {@link ViperRouting} and {@link ViperPresenterForRouting})
 */
public abstract class BaseRouting<PresenterType extends ViperPresenterForRouting>  // I prefer readability rather than conventions
        extends BaseRxRouting
        implements ViperRouting<PresenterType> {

    @Nullable
    private WeakReference<PresenterType> presenter;

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
    }

}
