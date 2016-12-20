package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperBasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.FullscreenPhotoInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.FullscreenPhotoRouting;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.FullscreenPhotoActivity;

public class FullscreenPhotoPresenter
        extends ViperBasePresenter<FullscreenPhotoContract.View,
                        FullscreenPhotoContract.Interactor,
                        FullscreenPhotoContract.Routing>
        implements FullscreenPhotoContract.Presenter,
        FullscreenPhotoContract.PresenterForInteractor,
        FullscreenPhotoContract.PresenterForRouting {

    private String mPhotoUrl;

    public FullscreenPhotoPresenter(Bundle bundle) {
        super(bundle);
        mPhotoUrl = getArgs().getString(FullscreenPhotoActivity.PHOTO_URL_EXTRA_STRING);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) getView().setPhoto(mPhotoUrl);
    }

    @NonNull
    @Override
    public FullscreenPhotoContract.Routing createRouting() {
        return new FullscreenPhotoRouting();
    }

    @NonNull
    @Override
    public FullscreenPhotoContract.Interactor createInteractor() {
        return new FullscreenPhotoInteractor();
    }


}
