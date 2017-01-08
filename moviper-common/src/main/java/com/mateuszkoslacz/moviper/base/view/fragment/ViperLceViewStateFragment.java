package com.mateuszkoslacz.moviper.base.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperLceViewStateFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends MvpLceViewStateFragment<ContentView, Model, ViewType, Presenter>
        implements MvpLceView<Model>, com.mateuszkoslacz.moviper.iface.view.ViperView {

    @Override
    public ViewStateType getViewState() {
        return (ViewStateType) super.getViewState();
    }

    @Override
    public Bundle getArgs() {
        return getArguments();
    }
}
