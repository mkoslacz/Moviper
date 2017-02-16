package com.mateuszkoslacz.moviper.mvi.base.view.viewholder.autoinject;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;

import butterknife.ButterKnife;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperButterKnifeViewHolder
        <DataObject,
                View extends MvpDataView,
                Presenter extends MviPresenter<View, ?>>
        extends MviperAiViewHolder<DataObject, View, Presenter> {

    public MviperButterKnifeViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @Override
    protected void injectViews(android.view.View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
