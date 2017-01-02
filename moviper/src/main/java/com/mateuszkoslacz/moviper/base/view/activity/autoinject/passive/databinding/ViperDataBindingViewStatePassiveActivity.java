package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperViewStateAiActivity;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperViewStateAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperDataBindingViewStatePassiveActivity
        <ViewType extends MvpView,
                ViewStateType extends ViewState<ViewType>,
                Binding extends ViewDataBinding>
        extends ViperViewStateAiPassiveActivity<ViewType, ViewStateType>
        implements ViperView {

    protected Binding mBinding;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBinding = DataBindingUtil.setContentView(this, layoutResID);
    }
}
