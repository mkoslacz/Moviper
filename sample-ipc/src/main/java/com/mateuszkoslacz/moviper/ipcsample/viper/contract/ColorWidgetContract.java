package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.annotation.ExternalCall;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

public interface ColorWidgetContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated();

        void synchronizeWidgetsColor();

        void synchronizeColorOfWidgetNamed(String widgetName);

        @ExternalCall
        void changeColorTo(int color);
    }

    interface View extends ViperView {

        void setName(String name);

        void setBackgroundColor(int color);
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting {

    }
}
