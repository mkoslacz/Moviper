package com.mateuszkoslacz.moviper3.base.presenter

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter

import java.util.LinkedList

/**
 * Created by mateuszkoslacz on 10.01.2017.
 *
 * It allows you to use multiple presenters in one view. It can be used with any of the passive
 * views.
 */

class ViperPresentersList<ViewType : MvpView>(vararg presenters: ViperRxPresenter<ViewType>)
    : ViperRxPresenter<ViewType> {

    private val presenters = LinkedList<ViperRxPresenter<ViewType>>().apply { addAll(presenters) }

    override val name = "ViperPresentersList - contents: ${presenters.fold(initial = "", operation = {allNames, presenter -> allNames + presenter.name + " "})}"

    override fun attachView(view: ViewType) {
        presenters.forEach { attachView(view) }
    }

    override fun detachView(retainInstance: Boolean) {
        presenters.forEach { detachView(retainInstance) }
    }

    override fun detachView() {
        presenters.forEach { detachView() }
    }

    override fun destroy() {
        presenters.forEach { destroy() }
    }
}
