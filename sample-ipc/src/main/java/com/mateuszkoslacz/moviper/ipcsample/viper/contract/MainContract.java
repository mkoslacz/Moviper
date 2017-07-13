package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import android.app.Activity;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

public interface MainContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated();
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
