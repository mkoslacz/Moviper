package com.mateuszkoslacz.moviper.ipcsample.viper.presenter;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.ipcsample.constants.Constants;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.ipcsample.viper.routing.MainRouting;

public class MainPresenter
        extends ViperActivityBaseRxPresenter
        <MainContract.View,
                MainContract.Interactor,
                MainContract.Routing>
        implements MainContract.Presenter {

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            getRouting().createAndAddWidgetToSlotWithGivenId(
                    Constants.NAME_BLUE,
                    Constants.COLOR_BLUE,
                    getView().getViewSlotIdForPosition(1));
            getRouting().createAndAddWidgetToSlotWithGivenId(
                    Constants.NAME_GREEN,
                    Constants.COLOR_GREEN,
                    getView().getViewSlotIdForPosition(2));
            getRouting().createAndAddWidgetToSlotWithGivenId(
                    Constants.NAME_RED,
                    Constants.COLOR_RED,
                    getView().getViewSlotIdForPosition(3));
        }
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting() {
        return new MainRouting();
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }
}
