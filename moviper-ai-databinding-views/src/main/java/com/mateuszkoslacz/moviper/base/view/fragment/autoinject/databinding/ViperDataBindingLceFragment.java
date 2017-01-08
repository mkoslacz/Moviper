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
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.ViperLceAiFragment;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperDataBindingLceFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>,
                Binding extends ViewDataBinding>
        extends ViperLceAiFragment<ContentView, Model, ViewType, Presenter>
        implements MvpLceView<Model>, com.mateuszkoslacz.moviper.iface.view.ViperView {

    protected Binding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mBinding.getRoot();
    }
}
