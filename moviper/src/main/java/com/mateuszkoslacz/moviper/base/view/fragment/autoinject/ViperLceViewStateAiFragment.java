package com.mateuszkoslacz.moviper.base.view.fragment.autoinject;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.fragment.mvp.MvpLceViewStateAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperLceViewStateAiFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpLceViewStateAiFragment<ContentView, Model, ViewType, Presenter>
        implements ViperLceView<Model> {

}
