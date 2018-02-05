package com.mateuszkoslacz.moviper3.iface.view

import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created by mateuszkoslacz on 01.12.2016.
 *
 *
 * The root view interface for every VIPER ViewHolder.
 * It shall not be used in Contract.
 */

interface ViperDataView<DataObject> : MvpDataView<DataObject>, ViperView, ContextHolder


interface MvpDataView<DataObject> : MvpView {

    var dataObject: DataObject
}

