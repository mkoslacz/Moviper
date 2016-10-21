package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.FullscreenPhotoInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.FullscreenPhotoRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.UserDetailsRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.FullscreenPhotoActivity;

public class FullscreenPhotoPresenter
        extends ViperActivityBaseRxPresenter
        <FullscreenPhotoContract.View,
                FullscreenPhotoContract.Interactor,
                FullscreenPhotoContract.Routing>
        implements
        FullscreenPhotoContract.Presenter {

    public FullscreenPhotoPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public String getPhotoUrlIntentFromUserDetailsActivity() {
        return isViewAttached() ? ((FullscreenPhotoActivity) getView()).getIntent()
                .getExtras().getString(UserDetailsRouting.PHOTO_EXTRA) : "";
    }

    @NonNull
    @Override
    public FullscreenPhotoContract.Routing createRouting(@NonNull Activity activity) {
        return new FullscreenPhotoRouting(activity);
    }

    @NonNull
    @Override
    public FullscreenPhotoContract.Interactor createInteractor() {
        return new FullscreenPhotoInteractor();
    }

}
