package com.mateuszkoslacz.moviper.base.view.viewholder.autoinject;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;

/**
 * Created by bwilk on 1/11/17.
 */

public abstract class ViperDataBindingViewHolder
        <DataObject,
                View extends MvpDataView,
                Presenter extends ViperPresenter<View>,
                Binding extends ViewDataBinding>
        extends ViperAiViewHolder<DataObject, View, Presenter> {

    protected Binding mBinding;

    public ViperDataBindingViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @Override
    protected void injectViews(android.view.View itemView) {
        mBinding = DataBindingUtil.bind(itemView);
    }
}
