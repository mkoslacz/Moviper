package com.mateuszkoslacz.moviper.iface.view;

/**
 * Created by mateuszkoslacz on 01.12.2016.
 */

public interface MvpViewHolder<DataObject> extends ViperView {

    void setDataObject(DataObject dataObject);

    DataObject getDataObject();
}
