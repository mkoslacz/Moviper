package com.mateuszkoslacz.moviper.base.view.activity.autoinject.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperLceViewStateAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingLceViewStateActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends LceViewState<Model, ViewType>,
                Binding extends ViewDataBinding>
        extends ViperLceViewStateAiActivity<ContentView, Model, ViewType, Presenter, ViewStateType>
        implements ViperLceView<Model> {

    protected Binding mBinding;

    @Override
    protected void injectViews() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }
}
