package com.mateuszkoslacz.moviper.base.view.fragment;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperLceFragment
        <ContentView extends View,
                Model,
                ViewType extends ViperLceView<Model>,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpLceFragment<ContentView, Model, ViewType, Presenter>
        implements ViperLceView<Model> {

}
