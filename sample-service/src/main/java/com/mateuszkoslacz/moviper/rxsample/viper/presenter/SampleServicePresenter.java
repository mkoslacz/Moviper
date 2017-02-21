package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.SampleServiceContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.SampleServiceInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.SampleServiceRouting;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SampleServicePresenter
        extends BaseRxPresenter<SampleServiceContract.View,
        SampleServiceContract.Interactor,
        SampleServiceContract.Routing>
        implements SampleServiceContract.Presenter {

    @Override
    public void attachView(@NonNull SampleServiceContract.View view) {
        super.attachView(view);

        getInteractor().getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user ->
                                Moviper.getInstance().getPresenters(MainPresenter.class)
                                        .subscribe(somePresenter
                                                -> somePresenter.showUsername(user.getLogin()))
                        , throwable -> {
                            throwable.printStackTrace();
                            Moviper.getInstance().getPresenters(MainPresenter.class)
                                    .subscribe(somePresenter
                                            -> somePresenter.changeServiceState());
                        }, () ->
                                Moviper.getInstance().getPresenters(MainPresenter.class)
                                        .subscribe(somePresenter
                                                -> somePresenter.changeServiceState())
                );
    }

    @NonNull
    @Override
    public SampleServiceContract.Routing createRouting() {
        return new SampleServiceRouting();
    }

    @NonNull
    @Override
    public SampleServiceContract.Interactor createInteractor() {
        return new SampleServiceInteractor();
    }
}