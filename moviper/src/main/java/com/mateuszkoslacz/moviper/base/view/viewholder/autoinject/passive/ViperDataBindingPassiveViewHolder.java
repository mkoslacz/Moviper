package com.mateuszkoslacz.moviper.base.view.viewholder.autoinject.passive;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.mateuszkoslacz.moviper.iface.view.MvpDataView;

/**
 * Created by bwilk on 1/11/17.
 */

public abstract class ViperDataBindingPassiveViewHolder
        <DataObject,
                View extends MvpDataView,
                Binding extends ViewDataBinding>
        extends ViperAiPassiveViewHolder<DataObject, View> {

    protected Binding mBinding;

    public ViperDataBindingPassiveViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @Override
    protected void injectViews(android.view.View itemView) {
        mBinding = DataBindingUtil.bind(itemView);
    }
}
