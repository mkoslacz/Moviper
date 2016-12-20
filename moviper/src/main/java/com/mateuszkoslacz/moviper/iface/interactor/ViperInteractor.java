package com.mateuszkoslacz.moviper.iface.interactor;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.ViperPresenterForInteractor;

/**
 * Created by mateuszkoslacz on  08.08.2016
 * Based on lucas.urbas implementation.
 * </p>
 * It's responsible for manipulating data on behalf of Presenter (see {@link ViperPresenter}).
 * It queries an API, DB etc.
 * </p>
 * It should be used in normal approach,
 * in which interactor has a reference to the presenter.
 */
public interface ViperInteractor<PresenterType extends ViperPresenterForInteractor>
        extends CommonViperInteractor {

    /**
     * Remember to call {@link #isPresenterAttached()} before getting the Presenter to avoid
     * {@link NullPointerException}s.
     *
     * @return attached {@link ViperPresenterForInteractor} subclass instance or
     * null if it's detached (View got destroyed)
     */
    @Nullable
    PresenterType getPresenter();

    /**
     * Checks if a presenter is attached to this interactor. You should always call this method
     * before calling {@link #getPresenter()} to get the presenter instance.
     *
     * @return true if presenter is attached or false if it's detached
     */
    boolean isPresenterAttached();

    /**
     * Attach the presenter to this interactor.
     * Will be called if the view has been attached to the presenter.
     * This method will be invoked from <code>ViperPresenter.attachView()</code>
     */
    void attach(PresenterType presenter);
}
