package com.mateuszkoslacz.moviper.iface.routing;

import android.app.Activity;
import android.support.annotation.Nullable;

/**
 * Created by tomasznajda on 16.12.2016.
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

public interface CommonViperRouting {

    /**
     * Remember to call {@link #isActivityAttached()} before getting the Activity to avoid {@link
     * NullPointerException}s.
     *
     * @return attached Activity instance or null if it's detached (View got destroyed)
     */
    @Nullable
    Activity getActivity();

    /**
     * Checks if a activity is attached to this routing. You should always call this method
     * before calling {@link #getActivity()} ()} to get the activity instance.
     *
     * @return true if Activity is attached or false if it's detached
     */
    boolean isActivityAttached();

    /**
     * Detach activity (and presenter {@link ViperRouting}) from this routing.
     * Will be called if the view has been destroyed.
     * This method will be invoked from <code>ViperPresenter.detachView()</code>
     */
    void detach(boolean retainInstance);
}
