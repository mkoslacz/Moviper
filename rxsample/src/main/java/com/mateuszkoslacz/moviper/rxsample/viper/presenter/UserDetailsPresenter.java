package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.data.model.User;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.UserDetailsInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;
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

    public UserDetailsPresenter(Activity activity) {
        super(activity);
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
                            Log.d("onUsers()", throwable.getMessage());
                            if (isViewAttached())
                                getView().showError(throwable, false);
                        }
                );
    }

    /*
    --------------------------------------------------------------------------
     */

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
