package com.mateuszkoslacz.moviper3.base.presenter

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.iface.presenter.ViperPresenter
import java.util.*

/**
 * Created by mateuszkoslacz on 10.01.2017.
 *
 * It allows you to use multiple presenters in one view. It can be used with any of the passive
 * views.
 */
class ViperPresentersList<ViewType : MvpView>(vararg presenters: ViperPresenter<ViewType>)
    : ViperPresenter<ViewType> {

    private val presenters = LinkedList<ViperPresenter<ViewType>>().apply { addAll(presenters) }

    override val name by lazy {
        "ViperPresentersList - contents: " +
                presenters.fold(initial = "",
                        operation = {allNames, presenter -> allNames + presenter.name + " "})
    }

    override fun attachView(view: ViewType) = presenters.forEach { it.attachView(view) }

    override fun detachView(retainInstance: Boolean) =
            presenters.forEach { it.detachView(retainInstance) }

    override fun detachView() = presenters.forEach { it.detachView() }

    override fun destroy() = presenters.forEach { it.destroy() }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ViperPresentersList<*>
        return presenters == other.presenters
    }

    override fun hashCode() = presenters.hashCode()
}
