package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.rxsample.data.model.User;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.FullscreenPhotoActivity;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

import static com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity.USER_EXTRA;

public class UserDetailsRouting
        extends ActivityBaseViewHelperRxRouting<
        UserDetailsContract.ViewHelper>
        implements UserDetailsContract.Routing {

    public UserDetailsRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void startFullscreenPhotoActivity(String avatarUrl) {
        if (isViewHelperAttached()) {
            FullscreenPhotoActivity.start(getActivity(), avatarUrl, getViewHelper().getAvatarImageView());
        }
    }

    @Override
    public User getUserDataIntent(UserDetailsActivity userDetailsActivity) {
        Intent intent = userDetailsActivity.getIntent();
        User userFromExtras = intent.getExtras().getParcelable(USER_EXTRA);
        return userFromExtras;
    }
}
