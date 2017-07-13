package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.ViperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * This is a base presenter class for callback VIPER concept. (see {@link MvpBasePresenter})
 * <p>
 * It contains the business logic of given VIPER screen. and references Interactor and Routing to
 * delegate them data and framework specific tasks.
 * <p>
 * You can use any Viper View with this class.
 */
public abstract class BasePresenter
        <ViewType extends MvpView,  // I prefer readability rather than conventions
                InteractorType extends ViperInteractor,
                RoutingType extends ViperRouting>
        extends CommonBasePresenter<ViewType>
        implements ViperPresenter<ViewType>,
        ViperPresenterForInteractor<InteractorType>,
        ViperPresenterForRouting<RoutingType> {

    @NonNull
    private RoutingType routing;

    @NonNull
    private InteractorType interactor;

    public BasePresenter() {
        this(null);
    }

    public BasePresenter(Bundle args) {
        super(args);
        this.routing = createRouting();
        this.interactor = createInteractor();
    }

    @Override
    public void attachView(ViewType view) {
        super.attachView(view);
        //noinspection unchecked
        routing.attach((ViperView) view, this);
        //noinspection unchecked
        interactor.attach(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        routing.detach(retainInstance);
        interactor.detach(retainInstance);
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
