package com.mateuszkoslacz.moviper.sample.viper.routing;

import com.mateuszkoslacz.moviper.base.routing.BaseViewHelperRouting;
import com.mateuszkoslacz.moviper.sample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.FullscreenPhotoActivity;

public class UserDetailsRouting
        extends BaseViewHelperRouting
        <UserDetailsContract.PresenterForRouting,
                UserDetailsContract.ViewHelper>
        implements UserDetailsContract.Routing {

    @Override
    public void startFullscreenPhotoActivity(String avatarUrl) {
        if (isViewHelperAttached()) {
            FullscreenPhotoActivity.start(getActivity(), avatarUrl,
                    getViewHelper().getAvatarImageView());
        }
    }
}
