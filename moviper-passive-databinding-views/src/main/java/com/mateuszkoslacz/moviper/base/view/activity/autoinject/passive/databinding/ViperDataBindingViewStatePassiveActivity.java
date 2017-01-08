package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperViewStateAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingViewStatePassiveActivity
        <ViewType extends MvpView,
                ViewStateType extends ViewState<ViewType>,
                Binding extends ViewDataBinding>
        extends ViperViewStateAiPassiveActivity<ViewType, ViewStateType>
        implements MvpView, ActivityHolder {

    protected Binding mBinding;

    @Override
    protected void injectViews() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }
}
