package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by jjodelka on 29/11/2016.
 * <p>
 * Viper - View, Interactor, Presenter, Entities, Routing
 * <p>
 * This is a ViewHolder version of base presenter class for mentioned set of concepts.
 * (see {@link MvpBasePresenter})
 * <p>
 * You can use any Mosby Activity View with this class
 * ({@link com.hannesdorfmann.mosby.mvp.MvpFragment},
 * {@link com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment})
 */

public abstract class ViperViewHolderBaseRxPresenter
        <ViewType extends ViperView,  // I prefer readability rather than conventions
                InteractorType extends MoviperRxInteractor,
                RoutingType extends MoviperRxRouting>
        extends MoviperBaseRxPresenter<ViewType>
        implements MoviperPresenter<ViewType>,
        MoviperPresenterForInteractor<InteractorType>,
        MoviperPresenterForRouting<RoutingType> {

    @NonNull
    private RoutingType routing;

    @NonNull
    private InteractorType interactor;

    public ViperViewHolderBaseRxPresenter() {
        super();
        this.routing = createRouting();
        this.interactor = createInteractor();
    }

    public ViperViewHolderBaseRxPresenter(Bundle args) {
        super(args);
        this.routing = createRouting();
        this.interactor = createInteractor();
    }

    @Override
    public void attachView(ViewType view) {
        super.attachView(view);
        routing.attachActivity(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        routing.onPresenterDetached(retainInstance);
        routing.detachActivity();
        interactor.onPresenterDetached(retainInstance);
    }

    @Override
    @Deprecated
    public boolean isRoutingAttached() {
        return routing != null;
    }

    @Override
    @Deprecated
    public boolean isInteractorAttached() {
        return interactor != null;
    }

    @NonNull
    @Override
    public RoutingType getRouting() {
        return routing;
    }

    @NonNull
    @Override
    public InteractorType getInteractor() {
        return interactor;
    }
}