package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
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
 * This is a base presenter class for rx VIPER concept. (see {@link MvpBasePresenter})
 * <p>
 * It contains the business logic of given VIPER screen and references Interactor and Routing to
 * delegate them data and framework specific tasks.
 * <p>
 * You can use any Viper View with this class ({@link com.mateuszkoslacz.moviper.base.view.activity.ViperActivity},
 * <br> {@link com.mateuszkoslacz.moviper.base.view.activity.ViperLceActivity}, <br> {@link
 * com.mateuszkoslacz.moviper.base.view.activity.ViperViewStateActivity}, <br> {@link
 * com.mateuszkoslacz.moviper.base.view.activity.ViperLceViewStateActivity}, <br> {@link
 * com.mateuszkoslacz.moviper.base.view.fragment.ViperFragment}, <br> {@link
 * com.mateuszkoslacz.moviper.base.view.fragment.ViperLceFragment}, <br> {@link
 * com.mateuszkoslacz.moviper.base.view.fragment.ViperLceViewStateFragment}, <br> {@link
 * com.mateuszkoslacz.moviper.base.view.fragment.ViperViewStateFragment},)
 */
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
