package com.mateuszkoslacz.moviper.ipcsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.ipcsample.viper.routing.MainRouting;

import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.COLOR_BLUE;
import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.COLOR_GREEN;
import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.COLOR_NAME_BLUE;
import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.COLOR_NAME_GREEN;
import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.COLOR_NAME_RED;
import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.COLOR_RED;
import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.FRAGMENT_NAME_FIRST;
import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.FRAGMENT_NAME_SECOND;
import static com.mateuszkoslacz.moviper.ipcsample.constants.Constants.FRAGMENT_NAME_THIRD;

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
            getRouting().prepareAndBindWidgetToView(FRAGMENT_NAME_FIRST,
                    COLOR_NAME_BLUE, COLOR_BLUE, getView().getViewIdForPosition(1));
            getRouting().prepareAndBindWidgetToView(FRAGMENT_NAME_SECOND,
                    COLOR_NAME_GREEN, COLOR_GREEN, getView().getViewIdForPosition(2));
            getRouting().prepareAndBindWidgetToView(FRAGMENT_NAME_THIRD,
                    COLOR_NAME_RED, COLOR_RED, getView().getViewIdForPosition(3));
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
