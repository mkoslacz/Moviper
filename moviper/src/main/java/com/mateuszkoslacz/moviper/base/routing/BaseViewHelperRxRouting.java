package com.mateuszkoslacz.moviper.base.routing;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.routing.ViperViewHelperRxRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.ViperViewHelper;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p/>
 * It's a Rx version of {@link BaseViewHelperRxRouting}.
 * <p/>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * <p/>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * <p/>
 * It also provides Android Views to use in Android Transaction with shared views, see {@link
 * BaseViewHelperRouting}
 */
public abstract class BaseViewHelperRxRouting<ViewHelperType extends ViperViewHelper> // I prefer readability rather than conventions
        extends BaseRxRouting
        implements ViperViewHelperRxRouting<ViewHelperType> {

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
