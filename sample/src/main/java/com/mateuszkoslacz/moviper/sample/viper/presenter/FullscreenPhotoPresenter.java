package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.FullscreenPhotoInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.FullscreenPhotoRouting;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.FullscreenPhotoActivity;

public class FullscreenPhotoPresenter
        extends ViperActivityBasePresenter<FullscreenPhotoContract.View,
        FullscreenPhotoContract.Interactor,
        FullscreenPhotoContract.Routing>
        implements
        FullscreenPhotoContract.Presenter,
        FullscreenPhotoContract.PresenterForInteractor,
        FullscreenPhotoContract.PresenterForRouting {

    private String mPhotoUrl;

    public FullscreenPhotoPresenter(Activity activity, Bundle bundle) {
        super(activity, bundle);
        mPhotoUrl = getArgs().getString(FullscreenPhotoActivity.PHOTO_URL_EXTRA_STRING);
    }

    @Override
    public String getPhotoUrl() {
        return mPhotoUrl;
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
