package com.mateuszkoslacz.moviper3.helper

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.base.presenter.ViperPresentersList
import com.mateuszkoslacz.moviper3.iface.presenter.ViperPresenter

fun <ViewType: MvpView> listOfPresenters(vararg presenters: ViperPresenter<ViewType>)
        = ViperPresentersList(*presenters)