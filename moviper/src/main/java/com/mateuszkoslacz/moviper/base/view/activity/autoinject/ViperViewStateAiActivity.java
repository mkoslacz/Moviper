package com.mateuszkoslacz.moviper.base.view.activity.autoinject;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.mvp.MvpViewStateAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperViewStateAiActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends MvpViewStateAiActivity<ViewType, Presenter>
        implements ViperView {

    @Override
    public ViewStateType getViewState() {
        return (ViewStateType) super.getViewState();
    }

    @NonNull
    @Override
    public Activity getActivity() {
        return this;
    }
}
