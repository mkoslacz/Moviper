package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.HeaderContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.HeaderInteractor;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderPresenter
        extends ViperActivityBaseRxPresenter<HeaderContract.View,
            HeaderContract.Interactor,
            HeaderContract.Routing>
        implements HeaderContract.Presenter {

    public HeaderPresenter(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void requestFillingView() {
        if (isViewAttached()) {
            getView().setTitleToTextView(getView().getTitle());
        }
    }

    @NonNull
    @Override
    public HeaderContract.Interactor createInteractor() {
        return new HeaderInteractor();
    }

    @NonNull
    @Override
    public HeaderContract.Routing createRouting(@NonNull Activity activity) {
        return null;
        // TODO: 29/11/2016
    }
}

