package com.mateuszkoslacz.rxpresenter.viper.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.app.Activity;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.rxpresenter.viper.contract.SampleContract;
import com.mateuszkoslacz.rxpresenter.viper.interactor.SampleInteractor;
import com.mateuszkoslacz.rxpresenter.viper.routing.SampleRouting;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class SamplePresenter
        extends ViperActivityBaseRxPresenter
        <SampleContract.View,
                SampleContract.Interactor,
                SampleContract.Routing>
        implements SampleContract.Presenter {

    public SamplePresenter(Activity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public SampleContract.Routing createRouting(@NonNull Activity activity) {
        return new SampleRouting(activity);
    }

    @NonNull
    @Override
    public SampleContract.Interactor createInteractor() {
        return new SampleInteractor();
    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) return;

        addSubscription(Observable.interval(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        number -> getView().showNumber(number),
                        Throwable::printStackTrace
                ));
    }
}
