package com.mateuszkoslacz.moviper.iface.interactor;

import android.support.annotation.Nullable;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.ViperPresenterForInteractor;

/**
 * Created by mateuszkoslacz on  08.08.2016 Based on lucas.urbas implementation.
 * <p/>
 * It's responsible for manipulating data on behalf of presenter, ie. saving data to db, getting
 * data from remotes etc.
 * <p/>
 * It provides Presenter reference to return data to it using callbacks. If you are looking for
 * solution adopted to Rx approach, see {@link ViperRxInteractor}.
 */
public interface ViperInteractor<PresenterType extends ViperPresenterForInteractor>
        extends CommonViperInteractor {

    /**
     * Remember to call {@link #isPresenterAttached()} before getting the Presenter to avoid {@link
     * NullPointerException}s.
     *
     * @return attached {@link ViperPresenterForInteractor} or null if it's detached (View got
     * destroyed)
     */
    @Nullable
    PresenterType getPresenter();

    /**
     * Checks if a presenter is attached to this interactor. You should always call this method
     * before calling {@link #getPresenter()} to get the presenter instance.
     */
    boolean isPresenterAttached();

    /**
     * You can override this to perform an action on presenter attach (ie. set up the resources, delegates etc.).
     * <b>Don't forget to call super!</b>
     * <p/>
     * Attaches a presenter to this interactor. Will be called right after view is attached to the
     * presenter. This method is invoked from {@link ViperPresenter#attachView(MvpView)}.
     */
    void attach(PresenterType presenter);
}
