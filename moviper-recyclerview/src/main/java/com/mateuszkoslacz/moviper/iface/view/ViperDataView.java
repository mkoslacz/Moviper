package com.mateuszkoslacz.moviper.iface.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 01.12.2016.
 * <p>
 * The root view interface for every VIPER ViewHolder.
 * It shall not be used in Contract.
 */

public interface ViperDataView<DataObject> extends MvpDataView<DataObject>, ViperView, ContextHolder {

}
