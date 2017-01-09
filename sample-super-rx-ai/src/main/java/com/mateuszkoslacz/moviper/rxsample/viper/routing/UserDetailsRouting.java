package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import com.mateuszkoslacz.moviper.base.routing.BaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.FullscreenPhotoActivity;

public class UserDetailsRouting
        extends BaseViewHelperRxRouting<UserDetailsContract.ViewHelper>
        implements UserDetailsContract.Routing {

    @Override
    public void startFullscreenPhotoActivity(String photoUrl) {
        if (isViewHelperAttached()) {
            FullscreenPhotoActivity.start(getActivity(), photoUrl,
                    getViewHelper().getAvatarImageView());
        }
    }
}