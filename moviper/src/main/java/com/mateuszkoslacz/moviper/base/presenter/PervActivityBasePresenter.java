package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

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
public abstract class PervActivityBasePresenter
        <RoutingType extends MoviperRouting,  // I prefer readability rather than conventions
                ViewType extends ViperView>
        extends MoviperBasePresenter<ViewType>
        implements MoviperPresenterForRouting<RoutingType>, MoviperPresenter<ViewType> {

    @NonNull
    private RoutingType routing;

    public PervActivityBasePresenter() {
        this(null);
    }

    public PervActivityBasePresenter(Bundle args) {
        super(args);
        this.routing = createRouting();
    }

    @Override
    @Deprecated
    public boolean isRoutingAttached() {
        return routing != null;
    }

    @Override
    public void attachView(ViewType view) {
        super.attachView(view);
        //noinspection unchecked
        routing.attachPresenter(this);
        routing.attachActivity(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        routing.detachPresenter();
        routing.detachActivity();
    }

    @NonNull
    @Override
    public RoutingType getRouting() {
        return routing;
    }
}
