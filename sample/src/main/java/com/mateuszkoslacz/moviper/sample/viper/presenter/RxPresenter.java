package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.sample.viper.contract.RxContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.RxInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.RxRouting;

public class RxPresenter
        extends ViperActivityBaseRxPresenter<RxContract.View,
        RxContract.Interactor,
        RxContract.Routing>
        implements
        RxContract.Presenter {

    public RxPresenter(Activity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public RxContract.Routing createRouting(@NonNull Activity activity) {
        return new RxRouting(activity);
    }

    @NonNull
    @Override
    public RxContract.Interactor createInteractor() {
        return new RxInteractor();
    }
}
