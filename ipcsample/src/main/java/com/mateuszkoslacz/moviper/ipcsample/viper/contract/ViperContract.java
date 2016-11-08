package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.annotation.ExternalCall;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRxRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;

public interface ViperContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated();

        void onButtonClick();

        void onButtonClick(String fragmentName);

        @ExternalCall
        void requestColorChange(int color);
    }

    interface View extends MvpView {

        void setColorName(String colorName);

        void setBackgroundColor(int color);
    }

    interface Interactor extends MoviperRxInteractor {

    }

    interface Routing extends MoviperViewHelperRxRouting<ViewHelper> {

    }

    interface ViewHelper extends MoviperViewHelper {

    }

}
