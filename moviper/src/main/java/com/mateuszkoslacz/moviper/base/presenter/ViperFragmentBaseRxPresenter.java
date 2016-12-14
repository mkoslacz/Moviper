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
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Viper - View, Interactor, Presenter, Entities, Routing
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
public abstract class ViperFragmentBaseRxPresenter
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

    public ViperFragmentBaseRxPresenter() {
        super();
        this.routing = createRouting();
        this.interactor = createInteractor();
    }

    public ViperFragmentBaseRxPresenter(Bundle args) {
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
        routing.detachActivity();
        routing.onPresenterDetached(retainInstance);
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
