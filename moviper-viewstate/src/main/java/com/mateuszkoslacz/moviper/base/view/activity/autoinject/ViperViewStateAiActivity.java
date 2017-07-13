package com.mateuszkoslacz.moviper.base.view.activity.autoinject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.mvp.MvpViewStateAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperViewStateAiActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends MvpViewStateAiActivity<ViewType, Presenter, ViewStateType>
        implements ViperView {

    @Override
    public ViewStateType getViewState() {
        return (ViewStateType) super.getViewState();
    }

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
