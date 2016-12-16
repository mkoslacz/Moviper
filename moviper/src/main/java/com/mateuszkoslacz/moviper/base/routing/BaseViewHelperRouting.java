package com.mateuszkoslacz.moviper.base.routing;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.ViperViewHelper;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Activity version of base Routing class with ViewHelper. (see {@link ViperViewHelperRouting},
 * {@link ViperViewHelper} and {@link ViperPresenterForRouting})
 */
public abstract class BaseViewHelperRouting
        <PresenterType extends ViperPresenterForRouting,  // I prefer readability rather than conventions
                ViewHelperType extends ViperViewHelper>
        extends BaseRouting<PresenterType>
        implements ViperViewHelperRouting<PresenterType, ViewHelperType> {

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
