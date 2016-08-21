package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.MainRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 */
public class MainPresenter
        extends ViperActivityBasePresenter<MainContract.View,
        MainContract.Interactor,
        MainContract.Routing>
        implements
        MainContract.Presenter,
        MainContract.PresenterForInteractor,
        MainContract.PresenterForRouting {


    public MainPresenter(Activity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting(@NonNull Activity activity) {
        return new MainRouting(activity);
    }
}
