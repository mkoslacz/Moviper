package com.mateuszkoslacz.sample.viper.presenter;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;
import com.mateuszkoslacz.sample.viper.contract.IndependentContract;
import com.mateuszkoslacz.sample.viper.interactor.IndependentInteractor;
import com.mateuszkoslacz.sample.viper.routing.IndependentRouting;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class IndependentPresenter
        extends BaseRxPresenter
        <ViperView,
                IndependentContract.Interactor,
                IndependentContract.Routing>
        implements ViperPresenter<ViperView> {

    public static final String UNIQUE_NAME = "INDEPENDENT_PRESENTER";

    private Disposable subscription;

    @Override
    public String getName() {
        return UNIQUE_NAME;
    }

    @NonNull
    @Override
    public IndependentContract.Routing createRouting() {
        return new IndependentRouting();
    }

    @NonNull
    @Override
    public IndependentContract.Interactor createInteractor() {
        return new IndependentInteractor();
    }

    @Override
    public void attachView(ViperView view) {
        super.attachView(view);

        subscription = getInteractor().getUserList()
                .flatMap(users -> Observable.zip(
                        Observable.fromIterable(users),
                        Observable.interval(2, TimeUnit.SECONDS),
                        (user, aLong) -> user
                ))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> getRouting().showUserToast(user),
                        throwable -> getRouting().showErrorToast(throwable)
                );
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (subscription != null && !subscription.isDisposed()) subscription.dispose();
        super.detachView(retainInstance);
    }
}
