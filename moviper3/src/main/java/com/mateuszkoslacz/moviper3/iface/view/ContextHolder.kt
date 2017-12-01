package com.mateuszkoslacz.moviper3.iface.view

import android.content.Context
import android.os.Bundle

import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created by mateuszkoslacz on 15.12.2016.
 *
 *
 * It's used for providing Context to the routing. Used in pair with [MvpView] in Moviper
 * views.
 * It's used in ViperService.
 */


interface ContextHolder {

    // TODO
    fun getContext(): Context?

    val args: Bundle?
}
