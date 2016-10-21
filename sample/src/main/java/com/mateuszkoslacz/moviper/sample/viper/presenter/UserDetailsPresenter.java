package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBasePresenter;
import com.mateuszkoslacz.moviper.sample.model.User;
import com.mateuszkoslacz.moviper.sample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.UserDetailsInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.ListingRouting;
import com.mateuszkoslacz.moviper.sample.viper.routing.UserDetailsRouting;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.UserDetailsActivity;

public class UserDetailsPresenter
        extends ViperActivityBasePresenter
        <UserDetailsContract.View,
                UserDetailsContract.Interactor,
                UserDetailsContract.Routing>
        implements
        UserDetailsContract.Presenter,
        UserDetailsContract.PresenterForInteractor,
        UserDetailsContract.PresenterForRouting {

    public UserDetailsPresenter(Activity activity) {
        super(activity);
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

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            getView().showLoading(false);
            getUserDataIntentFromListingActivity();
        }
    }

    @Override
    public void onAvatarClicked(String avatarUrl) {
        getRouting().startFullscreenPhotoActivity(avatarUrl);
    }

    private void getUserDataIntentFromListingActivity() {
        final UserDetailsActivity userDetailsActivity = (UserDetailsActivity) getView();
        Intent intent = userDetailsActivity.getIntent();
        User userFromExtras = intent.getExtras().getParcelable(ListingRouting.USER_EXTRA);

        userDetailsActivity.setLoginAndAvatarForUser(userFromExtras);

        getUserDataFromApi(userFromExtras.getLogin());
    }

    private void getUserDataFromApi(String userLogin) {
        if (isViewAttached())
            getInteractor().getUserForUsername(userLogin);
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
        if (isViewAttached())
            getView().showError(throwable, false);
    }
}
