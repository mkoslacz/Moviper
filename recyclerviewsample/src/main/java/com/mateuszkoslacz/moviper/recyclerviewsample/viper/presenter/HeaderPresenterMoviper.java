package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import com.mateuszkoslacz.moviper.base.presenter.ViperMoviperViewHolderBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.HeaderContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.HeaderInteractor;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing.HeaderRouting;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderPresenterMoviper
        extends ViperMoviperViewHolderBaseRxPresenter<
                    HeaderContract.View,
                    HeaderContract.Interactor,
                    HeaderContract.Routing>
        implements HeaderContract.Presenter {

    public HeaderPresenterMoviper(@NonNull View view) {
        super(view);
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
    public HeaderContract.Routing createRouting(@NonNull View view) {
        return new HeaderRouting((Activity) view.getContext());
    }
}

