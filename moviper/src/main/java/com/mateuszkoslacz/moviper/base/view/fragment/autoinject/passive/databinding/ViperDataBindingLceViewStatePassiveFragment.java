package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.ViperLceViewStateAiPassiveFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingLceViewStatePassiveFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                ViewStateType extends ViewState<ViewType>,
                Binding extends ViewDataBinding>
        extends ViperLceViewStateAiPassiveFragment<ContentView, Model, ViewType, ViewStateType>
        implements ViperLceView<Model> {

    protected Binding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mBinding.getRoot();
    }
}
