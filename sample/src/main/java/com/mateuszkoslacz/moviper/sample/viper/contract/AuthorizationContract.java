package com.mateuszkoslacz.moviper.sample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 10.08.2016.
 * <p>
 * It has less interfaces because it's a pure MVP contract.
 */
public interface AuthorizationContract {

    interface Presenter extends MvpPresenter<View> {

        void onUiCreated();
    }

    interface View extends MvpView {

        void showLoginFragment();

        void showRegisterFragment();
    }
}
