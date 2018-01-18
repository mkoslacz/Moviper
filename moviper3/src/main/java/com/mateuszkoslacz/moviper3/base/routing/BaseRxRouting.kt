package com.mateuszkoslacz.moviper3.base.routing

import android.content.Context

import com.mateuszkoslacz.moviper3.iface.routing.ViperRxRouting
import com.mateuszkoslacz.moviper3.iface.view.ContextHolder
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by mateuszkoslacz on 08.08.2016.
 *
 *
 * It's a Rx version of BaseRouting
 *
 *
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 *
 *
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 *
 *
 * In complex use cases you will probably want to include here separate classes for handling alarms
 * scheduling, Services creating etc. for better separation of concepts.
 *
 *
 */
abstract class BaseRxRouting<RelatedContext : Context> : ViperRxRouting<RelatedContext> {

    internal var context: RelatedContext? = null
    protected val disposables = CompositeDisposable()
    override val relatedContext: RelatedContext?
        get() = context

    @Suppress("UNCHECKED_CAST")
    override fun attach(contextHolder: ContextHolder) {
        this.context = contextHolder.getContext() as RelatedContext?
    }

    override fun detach(retainInstance: Boolean) = Unit

    override fun detach() {
        detach(true)
        context = null
    }

    override fun destroy() {
        detach(false)
        context = null // TODO do we need it or it's always preceded by detach()?
        disposables.dispose()
    }
}
