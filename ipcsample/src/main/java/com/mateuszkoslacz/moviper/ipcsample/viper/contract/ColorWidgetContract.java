package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.annotation.ExternalCall;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRxRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;

public interface ColorWidgetContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated();

        void synchronizeWidgetsColor();

        void synchronizeGivenWidgetColor(String widgetToSyncId);

        @ExternalCall
        void changeColorTo(int color);
    }

    interface View extends MvpView {

        void setWidgetName(String name);

        void setBackgroundColor(int color);
    }

    interface Interactor extends MoviperRxInteractor {

    }

    interface Routing extends MoviperViewHelperRxRouting<ViewHelper> {

    }

    interface ViewHelper extends MoviperViewHelper {

    }

}
