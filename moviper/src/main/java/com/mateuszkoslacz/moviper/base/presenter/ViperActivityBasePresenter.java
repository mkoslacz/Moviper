package com.mateuszkoslacz.moviper.base.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperActivityPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;

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
public abstract class ViperActivityBasePresenter
        <ViewType extends MvpView,  // I prefer readability rather than conventions
                InteractorType extends MoviperInteractor,
                RoutingType extends MoviperRouting>
        extends WipeBasePresenter<ViewType, InteractorType>
        implements MvpPresenter<ViewType>,
        MoviperPresenterForInteractor<InteractorType>,
        MoviperActivityPresenterForRouting<RoutingType> {

    @Nullable
    private RoutingType routing;

    public ViperActivityBasePresenter(@NonNull Activity activity) {
        super();
        this.routing = createRouting(activity);
    }

    public ViperActivityBasePresenter(@NonNull Activity activity, Bundle args) {
        super(args);
        this.routing = createRouting(activity);
    }

    @Override
    public boolean isRoutingAttached() {
        return routing != null;
    }

    @Override
    public void attachView(ViewType view) {
        super.attachView(view);
        assert routing != null;
        //noinspection unchecked
        routing.attachPresenter(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        assert routing != null;
        routing.detachPresenter();
        routing = null;
    }

    @Nullable
    @Override
    public RoutingType getRouting() {
        return routing;
    }
}
