package com.mateuszkoslacz.moviper.mvi.base.view.fragment.autoinject.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.mvi.base.view.fragment.autoinject.MviperAiFragment;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperDataBindingFragment
        <ViewType extends MvpView,
                PresenterType extends MviPresenter<ViewType, ?>,
                Binding extends ViewDataBinding>
        extends MviperAiFragment<ViewType, PresenterType> {

    protected Binding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mBinding.getRoot();
    }
}
