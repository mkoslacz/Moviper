package com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.MvpViewHolder;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;

/**
 * Created by jjodelka on 29/11/2016.
 */

public interface HeaderContract {

    interface Presenter extends MvpPresenter<View> {

    }

    interface View extends MvpViewHolder<Category> {

        void setTitle(String title);
    }

    interface Interactor extends MoviperRxInteractor {

    }

    interface Routing extends MoviperViewHelperRxRouting<ViewHelper> {

    }

    interface ViewHelper extends MoviperViewHelper {

    }
}

