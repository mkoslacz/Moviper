package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.support.annotation.NonNull;
import android.app.Activity;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.Fullscreen_photoContract;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.Fullscreen_photoRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.Fullscreen_photoInteractor;

public class Fullscreen_photoPresenter
        extends ViperActivityBaseRxPresenter
        <Fullscreen_photoContract.View,
                Fullscreen_photoContract.Interactor,
                Fullscreen_photoContract.Routing>
        implements
        Fullscreen_photoContract.Presenter {

    public Fullscreen_photoPresenter(Activity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fullscreen_photoContract.Routing createRouting(@NonNull Activity activity) {
        return new Fullscreen_photoRouting(activity);
    }

    @NonNull
    @Override
    public Fullscreen_photoContract.Interactor createInteractor() {
        return new Fullscreen_photoInteractor();
    }
}
