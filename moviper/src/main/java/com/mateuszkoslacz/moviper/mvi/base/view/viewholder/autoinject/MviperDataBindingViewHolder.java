package com.mateuszkoslacz.moviper.mvi.base.view.viewholder.autoinject;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperDataBindingViewHolder
        <DataObject,
                View extends MvpDataView,
                Presenter extends MviPresenter<View, ?>,
                Binding extends ViewDataBinding>
        extends MviperAiViewHolder<DataObject, View, Presenter> {

    protected Binding mBinding;

    public MviperDataBindingViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @Override
    protected void injectViews(android.view.View itemView) {
        mBinding = DataBindingUtil.bind(itemView);
    }
}
