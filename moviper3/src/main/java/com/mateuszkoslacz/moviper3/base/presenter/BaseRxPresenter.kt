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
import io.reactivex.disposables.Disposable
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
         InteractorType : ViperRxInteractor,
         RoutingType : ViperRxRouting<*>>(val args: Bundle? = null)
    : MvpBasePresenter<ViewType>(), ViperRxPresenter<ViewType> {

    protected var routing: RoutingType = createRouting()
    protected var interactor: InteractorType = createInteractor()
    private var viewWasAttached = false
    protected val disposables = CompositeDisposable()

    override val name = this.javaClass.name + "_" + Random().nextInt()

//    init {
//        // we shall not call non-final functions in constructor,
//        // because child-class fields won't be initialized in this moment,
//        // so it's very important to not to use any class fields in these methods!
//        @Suppress("LeakingThis")
//        this.routing = createRouting()
//        @Suppress("LeakingThis")
//        this.interactor = createInteractor()
//    }

    @Deprecated("Add your disposable to `disposables` val directly", ReplaceWith("disposable\n?.addTo(disposables)", "io.reactivex.rxkotlin.addTo"))
    protected fun addSubscription(disposable: Disposable?) = disposable?.let { disposables.add(it) }

    abstract fun initStreams()

    @Deprecated("do not override it to init your streams, use initStreams() instead! " +
            "You can still override it to perform some actions on each reattach to view.",
            ReplaceWith("initStreams()"))
    override fun attachView(view: ViewType) {
        super.attachView(view)
        routing.attach(view as ViperView)
        interactor.attach()
        if (viewWasAttached.not()) {
            Moviper.register(presenter = this)
            initStreams()
        }
        viewWasAttached = true
    }

    @Deprecated("This method has been split into 2 methods: {@link #detachView()} " +
            "and {@link #destroy()}", ReplaceWith("detachView()"))
    override fun detachView(retainInstance: Boolean) = Unit

    override fun detachView() {
        super.detachView()
        routing.detach()
        interactor.detach()
    }

    override fun destroy() {
        super.destroy()
        disposables.clear()
        Moviper.unregister(presenter = this)
        routing.destroy()
        interactor.destroy()
    }


    /**
     * **DO NOT USE ANY CLASS FIELDS IN THIS METHOD** - they won't be initialized at the moment
     * of calling this method!
     *
     * Override this and return a instantiated Routing object here.
     *
     * @return The ViperRouting for this view
     */
    abstract fun createRouting(): RoutingType

    /**
     * **DO NOT USE ANY CLASS FIELDS IN THIS METHOD** - they won't be initialized at the moment
     * of calling this method!
     *
     * Override this and return a instantiated Interactor object here.
     *
     * @return The ViperInteractor for this view
     */
    abstract fun createInteractor(): InteractorType

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
