package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListingPresenter
        extends ViperActivityBaseRxPresenter
        <ListingContract.View,
                ListingContract.Interactor,
                ListingContract.Routing>
        implements
        ListingContract.Presenter {

    public ListingPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) getView().showLoading();
        addSubscription(getInteractor().getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> {
                            if (isViewAttached()) {
                                getView().setUserList(user, false);
                                getView().showContent();
                            }
                        },
                        throwable -> {
                            if (isViewAttached()) getView().showError(throwable);
                        }
                ));
    }

    @Override
    public void onItemClicked(User user) {
        getRouting().startUserDetailsActivity(user);
    }

    @NonNull
    @Override
    public ListingContract.Routing createRouting(@NonNull Activity activity) {
        return new ListingRouting(activity);
    }

    @NonNull
    @Override
    public ListingContract.Interactor createInteractor() {
        return new ListingInteractor();
    }
}
