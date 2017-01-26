package com.mateuszkoslacz.moviper.base.view.viewholder.autoinject.passive;

import com.mateuszkoslacz.moviper.iface.view.MvpDataView;

import butterknife.ButterKnife;

/**
 * Created by bwilk on 1/11/17.
 */

public abstract class ViperButterKnifePassiveViewHolder
        <DataObject,
                View extends MvpDataView>
        extends ViperAiPassiveViewHolder<DataObject, View> {

    public ViperButterKnifePassiveViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @Override
    protected void injectViews(android.view.View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
