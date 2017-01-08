package com.mateuszkoslacz.moviper.base.view.activity.autoinject.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperLceViewStateAiActivity;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLceViewStateActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends ViperLceViewStateAiActivity<ContentView, Model, ViewType, Presenter, ViewStateType>
        implements MvpLceView<Model>, com.mateuszkoslacz.moviper.iface.view.ViperView {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
