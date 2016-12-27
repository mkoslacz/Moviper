package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.FullscreenPhotoInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.FullscreenPhotoRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.FullscreenPhotoActivity;

public class FullscreenPhotoPresenter
        extends BaseRxPresenter<FullscreenPhotoContract.View,
                                FullscreenPhotoContract.Interactor,
                                FullscreenPhotoContract.Routing>
        implements FullscreenPhotoContract.Presenter {

    private String mPhotoUrl;

    public FullscreenPhotoPresenter(Bundle bundle) {
        super(bundle);
        mPhotoUrl = getArgs().getString(FullscreenPhotoActivity.PHOTO_URL_EXTRA_STRING);
    }

    @Override
    public void attachView(FullscreenPhotoContract.View view) {
        super.attachView(view);
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
