package com.mateuszkoslacz.moviper.base.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>> //// TODO: 27.12.2016 why it's not a ViperPresenter?
        extends MvpActivity<ViewType, Presenter>
        implements MvpView, ActivityHolder {

    @NonNull
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Bundle getArgs() {
        return getIntent().getExtras();
    }
}
