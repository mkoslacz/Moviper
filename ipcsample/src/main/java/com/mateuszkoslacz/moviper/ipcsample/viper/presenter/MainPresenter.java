package com.mateuszkoslacz.moviper.ipcsample.viper.presenter;

import android.app.Activity;
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
        implements
        MainContract.Presenter {

    public MainPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            getRouting().createAndAddWidgetToSlotWithGivenId(
                    Constants.COLOR_NAME_BLUE,
                    Constants.COLOR_BLUE,
                    getView().getViewSlotIdForPosition(1));
            getRouting().createAndAddWidgetToSlotWithGivenId(
                    Constants.COLOR_NAME_GREEN,
                    Constants.COLOR_GREEN,
                    getView().getViewSlotIdForPosition(2));
            getRouting().createAndAddWidgetToSlotWithGivenId(
                    Constants.COLOR_NAME_RED,
                    Constants.COLOR_RED,
                    getView().getViewSlotIdForPosition(3));
        }
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting(@NonNull Activity activity) {
        return new MainRouting(activity);
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }
}
