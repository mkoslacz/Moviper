package com.mateuszkoslacz.moviper3.base.presenter

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter
import kotlin.reflect.KClass

class ViperMutablePresentersList<ViewType : MvpView>(vararg var presenters: ViperRxPresenter<ViewType>)
    : ViperRxPresenter<ViewType> {

    override val name
        get() =
            "ViperPresentersList - contents: " +
                    presenters.fold(initial = "",
                            operation = {allNames, presenter -> allNames + presenter.name + " "})


    fun appendPresenter(presenter: ViperRxPresenter<ViewType>, view: ViewType) {
        presenters = presenters.toMutableList().apply { add(presenter) }.toTypedArray()
        presenter.attachView(view)
    }

    fun <V : ViperRxPresenter<ViewType>> containsPresenterInstance(ofClass: KClass<V>) =
            presenters.find { it.javaClass == ofClass.java } != null

    override fun attachView(view: ViewType) = presenters.forEach { it.attachView(view) }

    override fun detachView(retainInstance: Boolean) =
            presenters.forEach { it.detachView(retainInstance) }

    override fun detachView() = presenters.forEach { it.detachView() }

    override fun destroy() = presenters.forEach { it.destroy() }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ViperMutablePresentersList<*>  // TODO add comparing to ViperPresentersList
        return presenters.contentEquals(other.presenters)
    }

    override fun hashCode() = presenters.hashCode()
}