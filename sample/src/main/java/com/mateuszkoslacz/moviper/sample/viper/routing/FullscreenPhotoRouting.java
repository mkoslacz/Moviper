package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRouting;
import com.mateuszkoslacz.moviper.sample.viper.contract.FullscreenPhotoContract;

import static com.mateuszkoslacz.moviper.sample.viper.view.activity.FullscreenPhotoActivity.PHOTO_EXTRA;

public class FullscreenPhotoRouting
        extends ActivityBaseRouting<
        FullscreenPhotoContract.PresenterForRouting>
        implements FullscreenPhotoContract.Routing {

    public FullscreenPhotoRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public String getPhotoUrlIntentFromUserDetailsActivity() {
        return isActivityAttached() ? getActivity().getIntent()
                .getExtras().getString(PHOTO_EXTRA) : "";
    }
}
