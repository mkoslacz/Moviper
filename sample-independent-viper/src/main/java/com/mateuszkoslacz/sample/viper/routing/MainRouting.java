package com.mateuszkoslacz.sample.viper.routing;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.sample.viper.IndependentVipersContainer;
import com.mateuszkoslacz.sample.viper.contract.MainContract;
import com.mateuszkoslacz.sample.viper.presenter.IndependentPresenter;

public class MainRouting
        extends BaseRxRouting
        implements MainContract.Routing {

    @Override
    public void startIndependentViper() {
        if (!isContextAttached()) return;

        IndependentPresenter presenter = new IndependentPresenter();
        IndependentVipersContainer.get()
                .startViper(IndependentPresenter.UNIQUE_NAME, presenter, getRelatedContext());
    }

    @Override
    public void stopIndependentViper() {
        if (!isContextAttached()) return;

        IndependentVipersContainer.get()
                .stopViper(IndependentPresenter.UNIQUE_NAME);
    }
}
