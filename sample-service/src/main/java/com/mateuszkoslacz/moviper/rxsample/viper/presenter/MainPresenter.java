package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.MainRouting;

public class MainPresenter
        extends BaseRxPresenter<MainContract.View,
        MainContract.Interactor,
        MainContract.Routing>
        implements MainContract.Presenter {

    private boolean isServiceRunning = false;

    @Override
    public void attachView(@NonNull MainContract.View view) {
        super.attachView(view);

        addSubscription(getView().getButtonClicks()
                .subscribe(o -> changeServiceState()));
    }

    public void changeServiceState() {
        if (isViewAttached()) {
            if (!isServiceRunning) {
                getView().setButtonText(getRouting().getRelatedContext()
                        .getResources().getString(R.string.stop_service));
                getRouting().startService();
                isServiceRunning = true;
            } else {
                getView().setButtonText(getRouting().getRelatedContext()
                        .getResources().getString(R.string.start_service));
                getRouting().stopService();
                isServiceRunning = false;
            }
        }
    }

    @Override
    public void showUsername(String username) {
        getRouting().showToastWithUsername(username);
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting() {
        return new MainRouting();
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }

}
