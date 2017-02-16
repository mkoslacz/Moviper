package com.mateuszkoslacz.moviper.mvi.base.view.activity.autoinject.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.tool.Binding;
import android.os.Bundle;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.mvi.base.view.activity.MviperActivity;
import com.mateuszkoslacz.moviper.mvi.base.view.activity.autoinject.MviperAiActivity;

/**
 * Created by mateuszkoslacz on 15.02.2017.
 */

public abstract class MviperDataBindingAiActivity
        <ViewType extends MvpView,
                PresenterType extends MviPresenter<ViewType, ?>,
                Binding extends ViewDataBinding>
        extends MviperAiActivity<ViewType, PresenterType> {

    protected Binding mBinding;

    protected void injectViews(){
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }
}
