package com.mateuszkoslacz.moviper3.iface.routing

import android.content.Context

import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter
import com.mateuszkoslacz.moviper3.iface.view.ContextHolder

/**
 * Created by tomasznajda on 16.12.2016. Based on lucas.urbas implementation.
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
 * If you are looking for solution providing Android Views to use in Android Transaction with shared
 * views, see ViperViewHelperRouting
 */
/**
 * Created by mateuszkoslacz on 08.08.2016. Based on lucas.urbas implementation.
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
 * If you are looking for solution providing Android Views to use in Android Transaction with shared
 * views, see ViperViewHelperRouting
 */
interface ViperRxRouting<out RelatedContext : Context> {

    /**
     * Remember to call [.isContextAttached] before getting the Activity to avoid [ ]s.
     *
     * @return attached Activity instance or null if it's detached (ie. View got destroyed)
     */
    val relatedContext: RelatedContext?

    /**
     * You can override this to perform an action on presenter detach (ie. free the resources etc.).
     * **Don't forget to call super!**
     *
     *
     * This method is called on Presenter detach, ie. when the view has been destroyed. This method
     * is invoked from [ViperRxPresenter.detachView]}.
     */
    fun detach(retainInstance: Boolean)

    /**
     * You can override this to perform an action on presenter attach (ie. set up the resources,
     * delegates etc.). **Don't forget to call super!**
     *
     *
     * Attaches a presenter to this interactor. Will be called right after view is attached to the
     * presenter. This method is invoked from [ViperRxPresenter.attachView].
     */
    fun attach(contextHolder: ContextHolder)


}
