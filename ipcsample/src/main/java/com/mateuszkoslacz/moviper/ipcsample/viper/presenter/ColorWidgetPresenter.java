package com.mateuszkoslacz.moviper.ipcsample.viper.presenter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.annotation.ExternalCall;
import com.mateuszkoslacz.moviper.base.presenter.ViperFragmentBaseRxPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ColorWidgetContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.interactor.ColorWidgetInteractor;
import com.mateuszkoslacz.moviper.ipcsample.viper.routing.ColorWidgetRouting;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

public class ColorWidgetPresenter
        extends ViperFragmentBaseRxPresenter
        <ColorWidgetContract.View,
                ColorWidgetContract.Interactor,
                ColorWidgetContract.Routing>
        implements
        ColorWidgetContract.Presenter {

    public static final String FRAGMENT_PRESENTER_NAME = "FRAGMENT_PRESENTER_NAME";
    public static final String FRAGMENT_COLOR_NAME = "FRAGMENT_COLOR_NAME";
    public static final String FRAGMENT_BACKGROUND_COLOR = "FRAGMENT_BACKGROUND_COLOR";

    private String presenterName;
    private String colorName;
    private int backgroundColor;

    public ColorWidgetPresenter(Fragment fragment, Bundle bundle) {
        super(fragment, bundle);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            colorName = getArgs().getString(FRAGMENT_COLOR_NAME);
            presenterName = getArgs().getString(FRAGMENT_PRESENTER_NAME);
            backgroundColor = Color.parseColor(getArgs().getString(FRAGMENT_BACKGROUND_COLOR));

            getView().setBackgroundColor(backgroundColor);
            getView().setWidgetName(colorName);
        }
    }

    @Override
    public void synchronizeWidgetsColor() {
        Moviper.getInstance().getPresenters(ColorWidgetPresenter.class)
                .subscribe(presenter -> presenter.changeColorTo(backgroundColor));
    }

    @Override
    public void synchronizeGivenWidgetColor(String widgetToSyncId) {
        Moviper.getInstance().getPresenterInstance(ColorWidgetPresenter.class, widgetToSyncId)
                .subscribe(presenter -> presenter.changeColorTo(backgroundColor));
    }

    @ExternalCall
    @Override
    public void changeColorTo(int color) {
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
    public ColorWidgetContract.Routing createRouting(@NonNull Fragment fragment) {
        return new ColorWidgetRouting(fragment);
    }

    @NonNull
    @Override
    public ColorWidgetContract.Interactor createInteractor() {
        return new ColorWidgetInteractor();
    }
}
