package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;

import com.mateuszkoslacz.moviper.base.routing.BaseViewHelperRouting;
import com.mateuszkoslacz.moviper.sample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.FullscreenPhotoActivity;

public class UserDetailsRouting
        extends BaseViewHelperRouting
        <Activity,
                UserDetailsContract.PresenterForRouting,
                UserDetailsContract.ViewHelper>
        implements UserDetailsContract.Routing {

    @Override
    public void startFullscreenPhotoActivity(String avatarUrl) {
        if (isContextAttached()) {
            FullscreenPhotoActivity.start(getRelatedContext(), avatarUrl,
                    getViewHelper().getAvatarImageView());
        }
    }
}
