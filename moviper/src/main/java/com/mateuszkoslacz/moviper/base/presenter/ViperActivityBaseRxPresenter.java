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
 * This is a Activity version of base presenter class for mentioned set of concepts.
 * (see {@link MvpBasePresenter})
 * <p>
 * You can use any Mosby Activity View with this class
 * ({@link com.hannesdorfmann.mosby.mvp.MvpActivity},
 * {@link com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity})
 */
//TODO migrate to MvpNullObjectPresenter base class?
public abstract class ViperActivityBaseRxPresenter
        <ViewType extends ViperView,  // I prefer readability rather than conventions
                InteractorType extends MoviperRxInteractor,
                RoutingType extends MoviperRxRouting>
        extends WipeBaseRxPresenter<ViewType, InteractorType>
        implements MoviperPresenter<ViewType>,
        MoviperPresenterForInteractor<InteractorType>,
        MoviperPresenterForRouting<RoutingType> {

    @NonNull
    private RoutingType routing;

    public ViperActivityBaseRxPresenter() {
        super();
        this.routing = createRouting();
    }

    public ViperActivityBaseRxPresenter(Bundle args) {
        super(args);
        this.routing = createRouting();
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
