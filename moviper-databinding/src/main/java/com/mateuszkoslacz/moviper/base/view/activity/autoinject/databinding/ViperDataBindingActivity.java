package com.mateuszkoslacz.moviper.base.view.activity.autoinject.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ContextHolder;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>,
                Binding extends ViewDataBinding>
        extends ViperAiActivity<ViewType, Presenter>
        implements ViperView {

    protected Binding mBinding;

    @Override
    protected void injectViews() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }
}