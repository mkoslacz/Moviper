package com.mateuszkoslacz.moviper.iface.view;

/**
 * Created by mateuszkoslacz on 01.12.2016.
 */

public interface ViperDataView<DataObject> extends ViperView {

    void setDataObject(DataObject dataObject);

    DataObject getDataObject();
}
