package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by norbertbanaszek on 09.11.2016.
 */

public class ViewHolderBaseViewHelperRouting<PresenterType extends MoviperPresenterForRouting,  // I prefer readability rather than conventions
        ViewHelperType extends MoviperViewHelper>
        extends ActivityBaseViewHelperRouting<PresenterType, ViewHelperType>
        implements MoviperViewHelperRouting<PresenterType, ViewHelperType> {

    @Nullable
    private WeakReference<Activity> activity;

    public ViewHolderBaseViewHelperRouting(@NonNull Activity activity) {
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
    public void detachPresenter() {
        super.detachPresenter();
        WeakReferenceUtils.detach(activity);
    }
}
