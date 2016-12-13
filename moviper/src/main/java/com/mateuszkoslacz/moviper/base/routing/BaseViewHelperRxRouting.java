package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRxRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Activity version of base Routing class with ViewHelper. (see {@link MoviperViewHelperRouting},
 * {@link MoviperViewHelper} and {@link MoviperPresenterForRouting})
 */
public abstract class BaseViewHelperRxRouting
        <ViewHelperType extends MoviperViewHelper> // I prefer readability rather than conventions
        extends BaseRxRouting
        implements MoviperViewHelperRxRouting<ViewHelperType> {

    public BaseViewHelperRxRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Nullable
    @Override
    public ViewHelperType getViewHelper() {
        //noinspection unchecked
        return (ViewHelperType) WeakReferenceUtils.get(activity);
    }

    @Override
    public boolean isViewHelperAttached() {
        return isActivityAttached();
    }
}
