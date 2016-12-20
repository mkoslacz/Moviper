package com.mateuszkoslacz.moviper.iface.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 01.12.2016.
 */

public interface MvpDataView<DataObject> extends MvpView {

    DataObject getDataObject();

    void setDataObject(DataObject dataObject);
}