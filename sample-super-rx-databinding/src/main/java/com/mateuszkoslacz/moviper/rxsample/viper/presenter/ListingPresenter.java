package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListingPresenter
        extends BaseRxPresenter<ListingContract.View,
                                ListingContract.Interactor,
                                ListingContract.Routing>
        implements ViperPresenter<ListingContract.View> {

    @Override
    public void attachView(@NonNull ListingContract.View view) {
        super.attachView(view);
        if (isViewAttached()) getView().showLoading();

        addSubscription(getInteractor().getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> {
                            if (isViewAttached()) {
                                getView().setUserList(user);
                                getView().showContent();
                            }
                        },
                        throwable -> {
                            if (isViewAttached())
                                getView().showError(throwable);
                        }
                ));
        if (isViewAttached()) addSubscription(getView().getUserClicks()
                .subscribe(user -> getRouting().startUserDetailsActivity(user)));
    }

    @NonNull
    @Override
    public ListingContract.Routing createRouting() {
        return new ListingRouting();
    }

    @NonNull
    @Override
    public ListingContract.Interactor createInteractor() {
        return new ListingInteractor();
    }
}
