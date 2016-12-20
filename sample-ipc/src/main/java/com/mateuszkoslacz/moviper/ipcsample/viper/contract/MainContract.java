package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
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

    interface Routing extends ViperRxRouting {

        void createAndAddWidgetToSlotWithGivenId(String widgetName, int widgetColor,
                                                 int destinationSlotId);
    }
}
