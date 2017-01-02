package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.ViperLceViewStateAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingLceViewStateFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>,
                Binding extends ViewDataBinding>
        extends ViperLceViewStateAiFragment<ContentView, Model, ViewType, Presenter, ViewStateType>
        implements ViperLceView<Model> {

    protected Binding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mBinding.getRoot();
    }
}
