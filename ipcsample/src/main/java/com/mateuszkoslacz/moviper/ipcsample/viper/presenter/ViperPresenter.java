package com.mateuszkoslacz.moviper.ipcsample.viper.presenter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.annotation.ExternalCall;
import com.mateuszkoslacz.moviper.base.presenter.ViperFragmentBaseRxPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ViperContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.interactor.ViperInteractor;
import com.mateuszkoslacz.moviper.ipcsample.viper.routing.ViperRouting;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

public class ViperPresenter
        extends ViperFragmentBaseRxPresenter
        <ViperContract.View,
                ViperContract.Interactor,
                ViperContract.Routing>
        implements
        ViperContract.Presenter {

    public static final String FRAGMENT_PRESENTER_NAME = "FRAGMENT_PRESENTER_NAME";
    public static final String FRAGMENT_COLOR_NAME = "FRAGMENT_COLOR_NAME";
    public static final String FRAGMENT_BACKGROUND_COLOR = "FRAGMENT_BACKGROUND_COLOR";

    private String presenterName;
    private String colorName;
    private int backgroundColor;

    public ViperPresenter(Fragment fragment, Bundle bundle) {
        super(fragment, bundle);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            colorName = getArgs().getString(FRAGMENT_COLOR_NAME);
            presenterName = getArgs().getString(FRAGMENT_PRESENTER_NAME);
            backgroundColor = Color.parseColor(getArgs().getString(FRAGMENT_BACKGROUND_COLOR));

            getView().setBackgroundColor(backgroundColor);
            getView().setColorName(colorName);
        }
    }

    @Override
    public void onButtonClick() {
        Moviper.getInstance().getPresenters(ViperPresenter.class)
                .subscribe(presenter -> presenter.requestColorChange(backgroundColor));
    }

    @Override
    public void onButtonClick(String fragmentName) {
        Moviper.getInstance().getPresenterInstance(ViperPresenter.class, fragmentName)
                .subscribe(presenter -> presenter.requestColorChange(backgroundColor));
    }

    @ExternalCall
    @Override
    public void requestColorChange(int color) {
        if (isViewAttached()) getView().setBackgroundColor(color);
    }

    @Override
    public String getName() {
        if (presenterName != null) {
            return presenterName;
        } else {
            return super.getName();
        }
    }

    @NonNull
    @Override
    public ViperContract.Routing createRouting(@NonNull Fragment fragment) {
        return new ViperRouting(fragment);
    }

    @NonNull
    @Override
    public ViperContract.Interactor createInteractor() {
        return new ViperInteractor();
    }
}
