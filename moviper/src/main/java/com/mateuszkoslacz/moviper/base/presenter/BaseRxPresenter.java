package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.ViperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

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
public abstract class BaseRxPresenter
        <ViewType extends MvpView,  // I prefer readability rather than conventions
                InteractorType extends ViperRxInteractor,
                RoutingType extends ViperRxRouting>
        extends CommonBasePresenter<ViewType>
        implements ViperPresenter<ViewType>,
        ViperPresenterForInteractor<InteractorType>,
        ViperPresenterForRouting<RoutingType> {

    @NonNull
    private RoutingType routing;

    @NonNull
    private InteractorType interactor;


    private CompositeSubscription compositeSubscription;

    public BaseRxPresenter() {
        this(null);
    }

    public BaseRxPresenter(Bundle args) {
        super(args);
        this.compositeSubscription = new CompositeSubscription();
        this.routing = createRouting();
        this.interactor = createInteractor();
    }

    @Override
    public void attachView(ViewType view) {
        super.attachView(view);
        Moviper.getInstance().register(this);
        routing.attach((ViperView) view);
        interactor.attach();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) unsubscribe();
        Moviper.getInstance().unregister(this);
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

    protected void addSubscription(Subscription subscription) {
        if (compositeSubscription != null) compositeSubscription.add(subscription);
    }

    private void unsubscribe() {
        if (compositeSubscription != null) compositeSubscription.clear();
    }
}
