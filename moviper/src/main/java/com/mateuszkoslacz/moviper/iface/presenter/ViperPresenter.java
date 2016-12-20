package com.mateuszkoslacz.moviper.iface.presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

public interface ViperPresenter<View extends MvpView> extends MvpPresenter<View> {

    String DEFAULT_NAME = "default";

    String getName();
}
