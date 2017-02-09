package com.mateuszkoslacz.moviper.base.routing;

import android.content.Context;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.ViperViewHelper;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * <p>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * <p>
 * It also provides Android Views to use in Android Transaction with shared views, see
 * {@link BaseViewHelperRouting}
 */
public abstract class BaseViewHelperRouting
        <RelatedContext extends Context,
                PresenterType extends ViperPresenterForRouting,
                ViewHelperType extends ViperViewHelper>
        extends BaseRouting<RelatedContext, PresenterType>
        implements ViperViewHelperRouting<RelatedContext, PresenterType, ViewHelperType> {

    @Nullable
    @Override
    public ViewHelperType getViewHelper() {
        //noinspection unchecked
        return (ViewHelperType) getRelatedContext();
    }

    @Override
    public boolean isViewHelperAttached() {
        return isContextAttached();
    }

}
