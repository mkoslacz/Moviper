package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperViewHolderPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;

/**
 * Created by norbertbanaszek on 09.11.2016.
 */

public abstract class ViperViewHolderBasePresenter <ViewType extends MvpView,  // I prefer readability rather than conventions
        InteractorType extends MoviperInteractor,
        RoutingType extends MoviperRouting>
        extends WipeBasePresenter<ViewType, InteractorType>
        implements MvpPresenter<ViewType>,
        MoviperPresenterForInteractor<InteractorType>,
        MoviperViewHolderPresenterForRouting<RoutingType> {

    @Nullable
    private RoutingType routing;

    public ViperViewHolderBasePresenter(@NonNull View view, Bundle args) {
        super(args);
        this.routing = createRouting(view);
    }

    public ViperViewHolderBasePresenter(@NonNull View view) {
        super();
        this.routing = createRouting(view);
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
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        routing.detachPresenter();
    }

    @NonNull
    @Override
    public RoutingType getRouting() {
        return routing;
    }
}

