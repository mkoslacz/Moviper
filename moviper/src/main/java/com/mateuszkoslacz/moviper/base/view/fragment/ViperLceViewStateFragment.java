package com.mateuszkoslacz.moviper.base.view.fragment;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperLceViewStateFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpLceViewStateFragment<ContentView, Model, ViewType, Presenter>
        implements ViperLceView<Model> {

}
