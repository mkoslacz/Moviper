package com.mateuszkoslacz.moviper.base.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperViewStateActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends MvpViewStateActivity<ViewType, Presenter>
        implements MvpView, ActivityHolder {

    @Override
    public ViewStateType getViewState() {
        return (ViewStateType) super.getViewState();
    }

    @NonNull
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Bundle getArgs() {
        return getIntent().getExtras();
    }
}
