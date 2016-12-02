package com.mateuszkoslacz.moviper.base.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperActivityPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

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
        <ViewType extends MvpView,  // I prefer readability rather than conventions
                InteractorType extends MoviperRxInteractor,
                RoutingType extends MoviperRxRouting>
        extends WipeBaseRxPresenter<ViewType, InteractorType>
        implements MoviperPresenter<ViewType>,
        MoviperPresenterForInteractor<InteractorType>,
        MoviperActivityPresenterForRouting<RoutingType> {

    @NonNull
    private RoutingType routing;

    public ViperActivityBaseRxPresenter(@NonNull Activity activity) {
        super();
        this.routing = createRouting(activity);
    }

    public ViperActivityBaseRxPresenter(@NonNull Activity activity, Bundle args) {
        super(args);
        this.routing = createRouting(activity);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
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
