package com.mateuszkoslacz.moviper3.base.presenter

import android.os.Bundle

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter
import com.mateuszkoslacz.moviper3.iface.routing.ViperRxRouting
import com.mateuszkoslacz.moviper3.iface.view.ViperView
import com.mateuszkoslacz.moviper3.presenterbus.Moviper

import io.reactivex.disposables.CompositeDisposable
import java.util.*

/**
 * Created by mateuszkoslacz on 08.08.2016.
 *
 *
 * This is a base presenter class for rx VIPER concept. (see [MvpBasePresenter])
 *
 *
 * It contains the business logic of given VIPER screen and references Interactor and Routing to
 * delegate them data and framework specific tasks.
 *
 *
 * You can use any Viper View with this class.
 */
abstract class BaseRxPresenter<ViewType : MvpView,
        out InteractorType : ViperRxInteractor,
        out RoutingType : ViperRxRouting<*>>(val args: Bundle? = null)
    : MvpBasePresenter<ViewType>(), ViperRxPresenter<ViewType, InteractorType, RoutingType> {

    final override val routing: RoutingType
    final override val interactor: InteractorType

    override val name = this.javaClass.name + "_" + Random().nextInt()

    protected val disposables = CompositeDisposable()

    init {
        // TODO we shall not call non-final functions in constructor,
        // because child-class fields won't be initialized in this moment,
        // so it's very important to not to use any class fields in these methods!
        @Suppress("LeakingThis")
        this.routing = createRouting()
        @Suppress("LeakingThis")
        this.interactor = createInteractor()
    }

    override fun attachView(view: ViewType) {
        super.attachView(view)
        Moviper.instance.register(presenter = this)
        routing.attach(view as ViperView)
        interactor.attach()
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        if (!retainInstance) disposables.clear()
        Moviper.instance.unregister(presenter = this)
        routing.detach(retainInstance)
        interactor.detach(retainInstance)
    }

    override fun detachView() { // TODO
        super.detachView()
        routing.detach(true)
        interactor.detach(true)
    }

    override fun destroy() { // TODO
        super.destroy()
        disposables.clear()
        Moviper.instance.unregister(presenter = this)
        routing.detach(false)
        interactor.detach(false)
    }

    override fun toString() = name

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as BaseRxPresenter<*, *, *>?
        return this.name == other.name
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + this.javaClass.hashCode()
        return result
    }
}
