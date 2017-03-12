package com.mateuszkoslacz.moviper.base.view.viewholder.autoinject;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;

import butterknife.ButterKnife;

/**
 * Created by bwilk on 1/11/17.
 */

public abstract class ViperButterKnifeViewHolder
        <DataObject,
                View extends MvpDataView,
                Presenter extends ViperPresenter<View>>
        extends ViperAiViewHolder<DataObject, View, Presenter> {


    public ViperButterKnifeViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @Override
    protected void injectViews(android.view.View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
