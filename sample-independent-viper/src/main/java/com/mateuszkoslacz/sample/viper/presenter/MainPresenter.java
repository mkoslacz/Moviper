package com.mateuszkoslacz.sample.viper.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;
import com.mateuszkoslacz.sample.viper.contract.MainContract;
import com.mateuszkoslacz.sample.viper.routing.MainRouting;
import com.mateuszkoslacz.sample.viper.interactor.MainInteractor;

public class MainPresenter
        extends BaseRxPresenter
        <MainContract.View,
                MainContract.Interactor,
                MainContract.Routing>
        implements ViperPresenter<MainContract.View> {

    @NonNull
    @Override
    public MainContract.Routing createRouting() {
        return new MainRouting();
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }

    @Override
    public void attachView(@NonNull MainContract.View view) {
        super.attachView(view);
        initButtons();
        handleViewEvents();
    }

    private void initButtons() {
        getView().enableStart();
        Moviper.getInstance()
                .getPresenterInstance(IndependentPresenter.class, IndependentPresenter.UNIQUE_NAME)
                .subscribe(independentPresenter -> getView().enableStop());
    }

    private void handleViewEvents() {
        addSubscription(getView().onStartClicks()
                .doOnNext(aVoid -> getView().enableStop())
                .subscribe(aVoid -> getRouting().startIndependentViper()));
        addSubscription(getView().onStopClicks()
                .doOnNext(aVoid -> getView().enableStart())
                .subscribe(aVoid -> getRouting().stopIndependentViper()));
    }
}
