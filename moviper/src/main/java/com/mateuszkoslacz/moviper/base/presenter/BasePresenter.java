package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.ViperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p/>
 * This is a base presenter class for callback VIPER concept. (see {@link MvpBasePresenter})
 * <p/>
 * It contains the business logic of given VIPER screen. and references Interactor and Routing to
 * delegate them data and framework specific tasks.
 * <p/>
 * You can use any Viper View with this class ({@link com.mateuszkoslacz.moviper.base.view.activity.ViperActivity},
 * <br/> {@link com.mateuszkoslacz.moviper.base.view.activity.ViperLceActivity}, <br/> {@link
 * com.mateuszkoslacz.moviper.base.view.activity.ViperViewStateActivity}, <br/> {@link
 * com.mateuszkoslacz.moviper.base.view.activity.ViperLceViewStateActivity}, <br/> {@link
 * com.mateuszkoslacz.moviper.base.view.fragment.ViperFragment}, <br/> {@link
 * com.mateuszkoslacz.moviper.base.view.fragment.ViperLceFragment}, <br/> {@link
 * com.mateuszkoslacz.moviper.base.view.fragment.ViperLceViewStateFragment}, <br/> {@link
 * com.mateuszkoslacz.moviper.base.view.fragment.ViperViewStateFragment},)
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
