package com.mateuszkoslacz.moviper.base.view.viewholder.autoinject;

import com.mateuszkoslacz.moviper.base.view.viewholder.ViperViewHolder;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;

/**
 * Created by bwilk on 1/11/17.
 */

public abstract class ViperAiViewHolder
        <DataObject,
                View extends MvpDataView,
                Presenter extends ViperPresenter<View>>
        extends ViperViewHolder<DataObject, View, Presenter> {

    public ViperAiViewHolder(android.view.View itemView) {
        super(itemView);
        injectViews(itemView);
    }

    abstract protected void injectViews(android.view.View itemView);
}
