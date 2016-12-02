package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRxRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by jjodelka on 29/11/2016.
 * <p>
 * ViewHolder version of base Routing class with ViewHelper. (see {@link MoviperViewHelperRouting},
 * {@link MoviperViewHelper} and {@link MoviperPresenterForRouting})
 */

public abstract class ViewHolderBaseViewHelperRxRouting<ViewHelperType extends MoviperViewHelper>
        extends ActivityBaseViewHelperRxRouting<ViewHelperType>
        implements MoviperViewHelperRxRouting<ViewHelperType> {

    @Nullable
    private WeakReference<Activity> activity;

    public ViewHolderBaseViewHelperRxRouting(@NonNull Activity activity) {
        super(activity);
        this.activity = new WeakReference<>(activity);
    }

    @Override
    public boolean isViewHelperAttached() {
        return WeakReferenceUtils.isAttached(activity);
    }

    @Nullable
    @Override
    public ViewHelperType getViewHelper() {
        //noinspection unchecked
        return ((ViewHelperType) WeakReferenceUtils.get(activity));
    }

    @Override
    public void onPresenterDetached(boolean retainInstance) {
        super.onPresenterDetached(retainInstance);
        WeakReferenceUtils.detach(activity);
    }
}
