package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperLceAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingLcePassiveActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Binding extends ViewDataBinding>
        extends ViperLceAiPassiveActivity<ContentView, Model, ViewType>
        implements MvpLceView<Model>, ViperView {

    protected Binding mBinding;

    @Override
    protected void injectViews() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }
}
