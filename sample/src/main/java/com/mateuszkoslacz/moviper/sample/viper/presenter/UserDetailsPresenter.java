package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.entity.User;
import com.mateuszkoslacz.moviper.sample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.UserDetailsInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.UserDetailsRouting;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.UserDetailsActivity;

public class UserDetailsPresenter
        extends BasePresenter<UserDetailsContract.View,
                                UserDetailsContract.Interactor,
                                UserDetailsContract.Routing>
        implements UserDetailsContract.Presenter,
        UserDetailsContract.PresenterForInteractor,
        UserDetailsContract.PresenterForRouting {

    public UserDetailsPresenter(Bundle bundle) {
        super(bundle);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            getView().showLoading(false);
            getUserDataFromApi(getArgs().getString(UserDetailsActivity.USER_EXTRA));
        }
    }

    @Override
    public void onAvatarClicked(String avatarUrl) {
        getRouting().startFullscreenPhotoActivity(avatarUrl);
    }

    private void getUserDataFromApi(String userLogin) {
        if (isViewAttached()) getInteractor().getUserForUsername(userLogin);
    }

    @Override
    public void onUserFetched(User user) {
        if (isViewAttached()) {
            getView().setData(user);
            new Handler(Looper.getMainLooper()).postDelayed(() ->
                    getView().showContent(), 100);
        }
    }

    @Override
    public void onUserFetchedError(Throwable throwable) {
        if (isViewAttached()) getView().showError(throwable, false);
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
