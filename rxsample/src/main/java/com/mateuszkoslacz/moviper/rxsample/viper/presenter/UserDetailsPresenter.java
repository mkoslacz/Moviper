package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.UserDetailsInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.UserDetailsRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserDetailsPresenter
        extends ViperActivityBaseRxPresenter
        <UserDetailsContract.View,
                UserDetailsContract.Interactor,
                UserDetailsContract.Routing>
        implements
        UserDetailsContract.Presenter {

    public UserDetailsPresenter(Activity activity, Bundle bundle) {
        super(activity, bundle);
    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        if(savedInstanceState != null) return;

        getView().showLoading(false);
        getUserDataFromApi(getArgs().getString(UserDetailsActivity.USER_EXTRA));
    }

    @Override
    public void onAvatarClicked(String avatarUrl) {
        getRouting().startFullscreenPhotoActivity(avatarUrl);
    }

    private void getUserDataFromApi(String userLogin) {
        addSubscription(getInteractor().getUserForUsername(userLogin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> {
                            getView().setData(user);
                            getView().showContent();
                        },
                        throwable -> {
                            getView().showError(throwable, false);
                        }
                ));
    }

    @NonNull
    @Override
    public UserDetailsContract.Routing createRouting(@NonNull Activity activity) {
        return new UserDetailsRouting(activity);
    }

    @NonNull
    @Override
    public UserDetailsContract.Interactor createInteractor() {
        return new UserDetailsInteractor();
    }
}
