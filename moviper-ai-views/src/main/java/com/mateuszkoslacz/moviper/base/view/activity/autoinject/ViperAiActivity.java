package com.mateuszkoslacz.moviper.base.view.activity.autoinject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.activity.mvp.MvpAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ContextHolder;
import com.mateuszkoslacz.moviper.iface.view.ContextHolder;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperAiActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpAiActivity<ViewType, Presenter>
        implements ViperView {

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
