package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.annotation.ExternalCall;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

public interface ColorWidgetContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated();

        void synchronizeWidgetsColor();

        void synchronizeColorOfWidgetNamed(String widgetName);

        @ExternalCall
        void changeColorTo(int color);
    }

    interface View extends MvpView {

        void setName(String name);

        void setBackgroundColor(int color);
    }

    interface Interactor extends MoviperRxInteractor {

    }

    interface Routing extends MoviperRxRouting {

    }
}
