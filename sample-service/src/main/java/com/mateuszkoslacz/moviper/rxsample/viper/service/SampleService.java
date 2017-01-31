package com.mateuszkoslacz.moviper.rxsample.viper.service;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.service.ViperService;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.SampleServiceContract;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.SampleServicePresenter;

public class SampleService
        extends ViperService<SampleServiceContract.View, SampleServiceContract.Presenter>
        implements SampleServiceContract.View {

    @NonNull
    @Override
    public SampleServiceContract.Presenter createPresenter() {
        return new SampleServicePresenter();
    }
}
