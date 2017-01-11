package com.mateuszkoslacz.moviper.base.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

public abstract class ViperIntentService
        <ViewType extends MvpView,
                Presenter extends ViperPresenter<ViewType>>
        extends MvpIntentService<ViewType, Presenter>
        implements ViperView {

    private Intent intent;

    public ViperIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        this.intent = intent;
    }

    @NonNull
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Bundle getArgs() {
        return intent != null ? intent.getExtras() : null;
    }

}
