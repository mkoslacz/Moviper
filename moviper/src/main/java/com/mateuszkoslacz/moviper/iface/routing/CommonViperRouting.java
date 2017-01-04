package com.mateuszkoslacz.moviper.iface.routing;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by tomasznajda on 16.12.2016. Based on lucas.urbas implementation.
 * <p/>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * <p/>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * <p/>
 * In complex use cases you will probably want to include here separate classes for handling alarms
 * scheduling, Services creating etc. for better separation of concepts.
 * <p/>
 * If you are looking for solution providing Android Views to use in Android Transaction with shared
 * views, see {@link ViperViewHelperRouting}
 */

public interface CommonViperRouting {

    /**
     * Remember to call {@link #isActivityAttached()} before getting the Activity to avoid {@link
     * NullPointerException}s.
     *
     * @return attached Activity instance or null if it's detached (ie. View got destroyed)
     */
    @Nullable
    Activity getActivity();

    /**
     * Checks if a activity is attached to this routing.
     */
    boolean isActivityAttached();

    /**
     * You can override this to perform an action on presenter detach (ie. free the resources etc.).
     * <b>Don't forget to call super!</b>
     * <p/>
     * This method is called on Presenter detach, ie. when the view has been destroyed. This method
     * is invoked from {@link ViperPresenter#detachView(boolean)}}.
     */
    void detach(boolean retainInstance);
}
