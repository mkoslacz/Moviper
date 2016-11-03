package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.FullscreenPhotoInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.FullscreenPhotoRouting;

public class FullscreenPhotoPresenter
        extends ViperActivityBasePresenter<FullscreenPhotoContract.View,
        FullscreenPhotoContract.Interactor,
        FullscreenPhotoContract.Routing>
        implements
        FullscreenPhotoContract.Presenter,
        FullscreenPhotoContract.PresenterForInteractor,
        FullscreenPhotoContract.PresenterForRouting {

    public FullscreenPhotoPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public String getPhotoUrlIntentFromUserDetailsActivity() {
        return getRouting().getPhotoUrlIntentFromUserDetailsActivity();
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
