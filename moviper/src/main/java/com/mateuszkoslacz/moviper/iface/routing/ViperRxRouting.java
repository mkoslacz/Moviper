package com.mateuszkoslacz.moviper.iface.routing;

import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * Based on lucas.urbas implementation.
 * </p>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * </p>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * </p>
 * In complex use cases you will probably want to include here separate classes for handling alarms
 * scheduling, Services creating etc. for better separation of concepts.
 * </p>
 * If you are looking for solution providing Android Views to use in Android Transaction with
 * shared views, see {@link ViperViewHelperRouting}
 */
public interface ViperRxRouting extends CommonViperRouting {

    /**
     * Attach the activity to this routing.
     * Will be called if the view has been attached to the presenter.
     * This method will be invoked from <code>ViperPresenter.attachView()</code>
     */
    void attach(ActivityHolder activityHolder);
}
