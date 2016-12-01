package com.mateuszkoslacz.moviper.iface.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 01.12.2016.
 */

public interface MvpViewHolder<DataObject> extends MvpView {

    void setDataObject(DataObject dataObject);

    DataObject getDataObject();
}
