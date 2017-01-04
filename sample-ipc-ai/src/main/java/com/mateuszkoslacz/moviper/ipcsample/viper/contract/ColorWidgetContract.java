package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.annotation.ExternalCall;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

public interface ColorWidgetContract {

    interface Presenter extends MvpPresenter<View> {

        void synchronizeWidgetsColor();

        void synchronizeColorOfWidgetNamed(String widgetName);

        @ExternalCall
        void changeColorTo(int color);
    }

    interface View extends MvpView {

        void setName(String name);

        void setBackgroundColor(int color);
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting {

    }
}
