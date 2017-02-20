package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.UserDetailsInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.UserDetailsRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserDetailsPresenter
        extends BaseRxPresenter<UserDetailsContract.View,
                                UserDetailsContract.Interactor,
                                UserDetailsContract.Routing>
        implements ViperPresenter<UserDetailsContract.View> {

    public UserDetailsPresenter(Bundle bundle) {
        super(bundle);
    }

    @Override
    public void attachView(UserDetailsContract.View view) {
        super.attachView(view);
        if (isViewAttached()) {
            getView().showLoading(false);
            getUserDataFromApi(getArgs().getString(UserDetailsActivity.USER_EXTRA));
            addSubscription(getView().getAvatarClicks()
                    .subscribe(getRouting()::startFullscreenPhotoActivity));
        }
    }

    private void getUserDataFromApi(String userLogin) {
        getInteractor().getUserForUsername(userLogin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> {
                            if (isViewAttached()) {
                                getView().setData(user);
                                getView().showContent();
                            }
                        },
                        throwable -> {
                            if (isViewAttached()) getView().showError(throwable, false);
                        }
                );
    }

    @NonNull
    @Override
    public UserDetailsContract.Routing createRouting() {
        return new UserDetailsRouting();
    }

    @NonNull
    @Override
    public UserDetailsContract.Interactor createInteractor() {
        return new UserDetailsInteractor();
    }
}
