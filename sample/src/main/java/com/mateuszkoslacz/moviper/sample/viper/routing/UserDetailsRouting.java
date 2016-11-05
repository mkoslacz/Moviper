package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRouting;
import com.mateuszkoslacz.moviper.sample.data.model.User;
import com.mateuszkoslacz.moviper.sample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.FullscreenPhotoActivity;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.UserDetailsActivity;

import static com.mateuszkoslacz.moviper.sample.viper.view.activity.UserDetailsActivity.USER_EXTRA;

public class UserDetailsRouting
        extends ActivityBaseViewHelperRouting<
        UserDetailsContract.PresenterForRouting,
        UserDetailsContract.ViewHelper>
        implements UserDetailsContract.Routing {

    public UserDetailsRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void startFullscreenPhotoActivity(String avatarUrl) {
        if (isViewHelperAttached()) {
            FullscreenPhotoActivity.start(getActivity(), avatarUrl,
                    getViewHelper().getAvatarImageView());
        }
    }
}
