package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperLceAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingLcePassiveActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Binding extends ViewDataBinding>
        extends ViperLceAiPassiveActivity<ContentView, Model, ViewType>
        implements ViperLceView<Model> {

    protected Binding mBinding;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBinding = DataBindingUtil.setContentView(this, layoutResID);
    }
}
