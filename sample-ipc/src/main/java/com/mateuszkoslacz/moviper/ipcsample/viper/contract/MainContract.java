package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

public interface MainContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated();
    }

    interface View extends ViperView {

        int getViewSlotIdForPosition(int position);
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting {

        void createAndAddWidgetToSlotWithGivenId(String widgetName, int widgetColor,
                                                 int destinationSlotId);
    }
}
