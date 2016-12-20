package com.mateuszkoslacz.moviper.base.view.fragment;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperLceViewStateFragment
        <ContentView extends View,
                Model,
                ViewType extends ViperLceView<Model>,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends MvpLceViewStateFragment<ContentView, Model, ViewType, Presenter>
        implements ViperLceView<Model> {

    @Override
    public ViewStateType getViewState() {
        return (ViewStateType) super.getViewState();
    }
}
