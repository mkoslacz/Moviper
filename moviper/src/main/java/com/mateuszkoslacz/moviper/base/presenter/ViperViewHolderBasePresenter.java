package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperViewHolderPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by norbertbanaszek on 26.10.2016.
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

public abstract class ViperViewHolderBasePresenter<ViewType extends ViperView,
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
        routing.attachActivity(view.getActivity());
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

