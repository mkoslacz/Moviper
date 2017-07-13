package com.mateuszkoslacz.moviper.iface.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 01.12.2016.
 * <p>
 * The root view interface for every MVP ViewHolder
 */

public interface MvpDataView<DataObject> extends MvpView {

    DataObject getDataObject();

    void setDataObject(DataObject dataObject);
}