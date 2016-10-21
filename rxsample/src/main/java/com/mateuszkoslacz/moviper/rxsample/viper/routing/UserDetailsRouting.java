package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRxRouting;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.FullscreenPhotoActivity;

public class UserDetailsRouting
        extends ActivityBaseViewHelperRxRouting<
        UserDetailsContract.ViewHelper>
        implements UserDetailsContract.Routing {

    public static final String PHOTO_EXTRA = "PHOTO_EXTRA";

    public UserDetailsRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void startFullscreenPhotoActivity(String avatarUrl) {
        Intent intent = new Intent(getActivity(), FullscreenPhotoActivity.class);
        intent.putExtra(PHOTO_EXTRA, avatarUrl);

        if (isActivityAttached()) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(getActivity(), getViewHelper().getAvatarImageView(),
                            getActivity().getString(R.string.avatar_transition));
            getActivity().startActivity(intent, optionsCompat.toBundle());
        }
    }
}
