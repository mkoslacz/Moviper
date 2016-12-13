package com.mateuszkoslacz.moviper.iface.routing;

import android.app.Activity;
import android.support.annotation.Nullable;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * It's responsible for performing all platform-specific tasks in behalf of presenter, ie. starting
 * a new Activity, a new Service, scheduling alarms etc.
 * <p>
 * It's also responsible of UI changes outside of given view, ie. Fragment presenter uses this
 * routing for switching Fragments in parent Activity.
 * <p>
 * In complex use cases you will probably want to include here separate classes for handling alarms
 * scheduling, Services creating etc. for better separation of concepts.
 * <p>
 * If you are looking for solution providing Android Views to use in Android Transaction with shared
 * views, see {@link MoviperViewHelperRouting}
 */
// I prefer readability rather than conventions
public interface MoviperRxRouting {

    /**
     * Remember to call {@link #isActivityAttached()} before getting the Activity to avoid {@link
     * NullPointerException}s.
     *
     * @return attached Activity instance or null if it's detached (View got destroyed)
     */
    @Nullable
    Activity getActivity();

    boolean isActivityAttached();

    void attachActivity(Activity activity);

    void detachActivity();

    void onPresenterDetached(boolean retainInstance);

    @Deprecated
    void onPresenterDetached();
}
