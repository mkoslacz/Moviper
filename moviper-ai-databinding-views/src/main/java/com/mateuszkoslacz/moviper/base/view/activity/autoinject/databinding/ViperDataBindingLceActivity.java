package com.mateuszkoslacz.moviper.base.view.activity.autoinject.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperLceAiActivity;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingLceActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>,
                Binding extends ViewDataBinding>
        extends ViperLceAiActivity<ContentView, Model, ViewType, Presenter>
        implements MvpLceView<Model>, com.mateuszkoslacz.moviper.iface.view.ViperView {

    protected Binding mBinding;

    @Override
    protected void injectViews() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }
}
