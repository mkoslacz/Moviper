package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperFragmentPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 * <p>
 * Perv - Presenter, Entities, Routing, View.
 * <p>
 * This is a Fragment version of base presenter class for mentioned set of concepts.
 * (see {@link MvpBasePresenter})
 * <p>
 * You can use any Mosby Activity View with this class
 * ({@link com.hannesdorfmann.mosby.mvp.MvpFragment},
 * {@link com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment})
 */
//TODO migrate to MvpNullObjectPresenter base class?
public abstract class PervFragmentBaseRxPresenter
        <RoutingType extends MoviperRxRouting,  // I prefer readability rather than conventions
                ViewType extends MvpView>
        extends MoviperBasePresenter<ViewType>
        implements MoviperFragmentPresenterForRouting<RoutingType>,
        MoviperPresenter<ViewType> {

    private Bundle args;
    @NonNull
    private RoutingType routing;

    public PervFragmentBaseRxPresenter(@NonNull Fragment fragment) {
        this(fragment, null);
    }

    public PervFragmentBaseRxPresenter(@NonNull Fragment fragment, Bundle args) {
        super();
        this.args = args;
        this.routing = createRouting(fragment);
    }

    @Override
    @Deprecated
    public boolean isRoutingAttached() {
        return routing != null;
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        routing.onPresenterDetached();
    }

    @NonNull
    @Override
    public RoutingType getRouting() {
        return routing;
    }

    public Bundle getArgs() {
        return args;
    }
}
