package com.mateuszkoslacz.moviper.mvi.base.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvi.MviActivity;
import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 13.02.2017.
 */

public abstract class MviperActivity
        <ViewType extends MvpView,
                PresenterType extends MviPresenter<ViewType, ?>>
        extends MviActivity<ViewType, PresenterType>
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
