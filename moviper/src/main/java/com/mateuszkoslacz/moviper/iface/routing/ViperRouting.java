package com.mateuszkoslacz.moviper.iface.routing;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;

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
 * views, see {@link ViperViewHelperRouting}
 */
// I prefer readability rather than conventions
public interface ViperRouting<PresenterType extends ViperPresenterForRouting>
        extends ViperRxRouting {

    /**
     * Remember to call {@link #isPresenterAttached()} ()} before getting the Presenter to avoid
     * {@link NullPointerException}s.
     *
     * @return attached Moviper {@link com.hannesdorfmann.mosby.mvp.MvpBasePresenter} subclass
     * instance or null if it's detached (View got destroyed)
     */
    @Nullable
    PresenterType getPresenter();

    boolean isPresenterAttached();

    // TODO: 04.10.2016 move attaching presenter to constructor
    void attachPresenter(PresenterType presenter);

    void detachPresenter();
}
