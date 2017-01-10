package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import android.app.Activity;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

public interface MainContract {

    interface Presenter extends MvpPresenter<View> {

    }

    interface View extends MvpView {

        int getViewSlotIdForPosition(int position);
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting<Activity> {

        void createAndAddWidgetToSlotWithGivenId(String widgetName, int widgetColor,
                                                 int destinationSlotId);
    }
}
