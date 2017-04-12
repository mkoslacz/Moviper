package com.mateuszkoslacz.moviper.base.view.viewholder.autoinject;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

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

    @Override
    public void setDataObject(DataObject dataObject) {
        super.setDataObject(dataObject);
        bindViews();
    }

    /**
     * It's called only once, on ViewHolder creation ({@link RecyclerView.Adapter#onCreateViewHolder(ViewGroup,
     * int)}. Inject view references and other reusable components here.
     */
    protected void injectViews(android.view.View itemView) {
        // stub
    }

    /**
     * It's called multiple times, on ViewHolder binding ({@link RecyclerView.Adapter#onBindViewHolder(RecyclerView.ViewHolder,
     * int)}}. Bind data from DataObject to views here.
     */
    protected void bindViews() {
        // stub
    }
}
