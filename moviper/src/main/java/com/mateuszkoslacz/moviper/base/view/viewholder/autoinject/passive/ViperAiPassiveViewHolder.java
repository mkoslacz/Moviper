package com.mateuszkoslacz.moviper.base.view.viewholder.autoinject.passive;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.view.viewholder.autoinject.ViperAiViewHolder;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;

/**
 * Created by bwilk on 1/11/17.
 */

public abstract class ViperAiPassiveViewHolder
        <DataObject,
                View extends MvpDataView>
        extends ViperAiViewHolder<DataObject, View, ViperPresenter<View>> {

    public ViperAiPassiveViewHolder(android.view.View itemView) {
        super(itemView);
    }

    /**
     * <b>DO NOT</b> use this method because of a fact that this view should be completely passive
     * (independent from the presenter type)! <br/>
     * Instead you should use getters to provide
     * event sources that will notify presenter after presenter's registration to them. To use
     * getPresenter() method you shall use non-passive Moviper view.
     *
     * @return raw {@link ViperPresenter}, so you can't call any custom methods on it anyway
     */
    @NonNull
    @Override
    @Deprecated
    public ViperPresenter<View> getPresenter() {
        return super.getPresenter();
    }
}
