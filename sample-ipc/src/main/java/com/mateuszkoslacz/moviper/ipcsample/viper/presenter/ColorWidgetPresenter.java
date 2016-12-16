package com.mateuszkoslacz.moviper.ipcsample.viper.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.annotation.ExternalCall;
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ColorWidgetContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.interactor.ColorWidgetInteractor;
import com.mateuszkoslacz.moviper.ipcsample.viper.routing.ColorWidgetRouting;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

import rx.android.schedulers.AndroidSchedulers;

public class ColorWidgetPresenter
        extends BaseRxPresenter<ColorWidgetContract.View,
                        ColorWidgetContract.Interactor,
                        ColorWidgetContract.Routing>
        implements ColorWidgetContract.Presenter {

    public static final String FRAGMENT_COLOR_NAME = "FRAGMENT_COLOR_NAME";
    public static final String FRAGMENT_BACKGROUND_COLOR = "FRAGMENT_BACKGROUND_COLOR";

    private String colorName;
    private int backgroundColor;

    public ColorWidgetPresenter(Bundle bundle) {
        super(bundle);
    }

    @Override
    public void attachView(ColorWidgetContract.View view) {
        colorName = getArgs().getString(FRAGMENT_COLOR_NAME);
        backgroundColor = getArgs().getInt(FRAGMENT_BACKGROUND_COLOR);
        super.attachView(view);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            getView().setBackgroundColor(backgroundColor);
            getView().setName(colorName);
        }
    }

    @Override
    public void synchronizeWidgetsColor() {
        Moviper.getInstance().getPresenters(ColorWidgetPresenter.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter -> presenter.changeColorTo(backgroundColor));
    }

    @Override
    public void synchronizeColorOfWidgetNamed(String widgetName) {
        Moviper.getInstance().getPresenterInstance(ColorWidgetPresenter.class, widgetName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter -> presenter.changeColorTo(backgroundColor));
    }

    @ExternalCall
    @Override
    public void changeColorTo(int color) {
        if (isViewAttached()) getView().setBackgroundColor(color);
    }

    @Override
    public String getName() {
        return colorName;
    }

    @NonNull
    @Override
    public ColorWidgetContract.Routing createRouting() {
        return new ColorWidgetRouting();
    }

    @NonNull
    @Override
    public ColorWidgetContract.Interactor createInteractor() {
        return new ColorWidgetInteractor();
    }
}
