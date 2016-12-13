package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by jjodelka on 01/12/2016.
 */

public class ViewHolderBaseRouting
        <PresenterType extends MoviperPresenterForRouting>
        extends BaseRouting<PresenterType>
        implements MoviperRouting<PresenterType> {

    @Nullable
    private WeakReference<Activity> activity;

    public ViewHolderBaseRouting(@NonNull Activity activity) {
        super(activity);
        this.activity = new WeakReference<>(activity);
    }

    @Override
    public void detachPresenter() {
        super.detachPresenter();
        WeakReferenceUtils.detach(activity);
    }

}
