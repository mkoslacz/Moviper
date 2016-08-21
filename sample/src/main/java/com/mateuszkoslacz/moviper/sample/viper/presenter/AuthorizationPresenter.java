package com.mateuszkoslacz.moviper.sample.viper.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.contract.AuthorizationContract;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 */
public class AuthorizationPresenter
        extends MvpBasePresenter<AuthorizationContract.View>
        implements AuthorizationContract.Presenter {

    @Override
    public void onUiCreated() {
        if (isViewAttached()) getView().showLoginFragment();
    }
}
