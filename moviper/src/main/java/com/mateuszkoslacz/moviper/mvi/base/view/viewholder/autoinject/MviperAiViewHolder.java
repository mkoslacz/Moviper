package com.mateuszkoslacz.moviper.mvi.base.view.viewholder.autoinject;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;
import com.mateuszkoslacz.moviper.mvi.base.view.viewholder.MviperViewHolder;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperAiViewHolder
        <DataObject,
                View extends MvpDataView,
                Presenter extends MviPresenter<View, ?>>
        extends MviperViewHolder<DataObject, View, Presenter> {

    public MviperAiViewHolder(android.view.View itemView) {
        super(itemView);
        injectViews(itemView);
    }

    abstract protected void injectViews(android.view.View itemView);
}
