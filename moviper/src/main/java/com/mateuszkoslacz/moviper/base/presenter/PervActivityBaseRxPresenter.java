package com.mateuszkoslacz.moviper.base.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperActivityPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 * <p>
 * Perv - Presenter, Entities, Routing, View.
 * <p>
 * This is an Activity version of base presenter class for mentioned set of concepts.
 * (see {@link MvpBasePresenter})
 * <p>
 * You can use any Mosby Activity View with this class
 * ({@link com.hannesdorfmann.mosby.mvp.MvpActivity},
 * {@link com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity})
 */
//TODO migrate to MvpNullObjectPresenter base class?
public abstract class PervActivityBaseRxPresenter
        <RoutingType extends MoviperRxRouting,  // I prefer readability rather than conventions
                ViewType extends MvpView>
        extends MoviperBasePresenter<ViewType>
        implements MoviperActivityPresenterForRouting<RoutingType>,
        MoviperPresenter<ViewType> {

    protected Bundle args;
    @NonNull
    private RoutingType routing;


    public PervActivityBaseRxPresenter(@NonNull Activity activity) {
        this(activity, null);
    }

    public PervActivityBaseRxPresenter(@NonNull Activity activity, Bundle args) {
        super();
        this.args = args;
        this.routing = createRouting(activity);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        routing.onPresenterDetached();
    }

    @Override
    @Deprecated
    public boolean isRoutingAttached() {
        return routing != null;
    }

    @NonNull
    @Override
    public RoutingType getRouting() {
        return routing;
    }

}
