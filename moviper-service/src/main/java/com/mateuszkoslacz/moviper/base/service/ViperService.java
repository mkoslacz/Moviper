package com.mateuszkoslacz.moviper.base.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

public abstract class ViperService
        <ViewType extends MvpView,
                Presenter extends ViperPresenter<ViewType>>
        extends MvpService<ViewType, Presenter>
        implements ViperView {

    private Intent intent;

    @NonNull
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Bundle getArgs() {
        return intent != null ? intent.getExtras() : null;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        this.intent = intent;
        return null;
    }
}
