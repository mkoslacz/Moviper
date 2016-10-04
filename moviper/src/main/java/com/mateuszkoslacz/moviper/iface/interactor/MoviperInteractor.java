package com.mateuszkoslacz.moviper.iface.interactor;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;

/**
 * Created by lucas.urbas on 29/08/15.
 * <p>
 * Adapted and modified by mateuszkoslacz on  08.08.2016.
 * <p>
 * It's responsible of manipulating data on behalf of Presenter (see Mosby's
 * {@link com.hannesdorfmann.mosby.mvp.MvpPresenter}). It queries an API, DB etc.
 */
// I prefer readability rather than conventions
public interface MoviperInteractor<PresenterType extends MoviperPresenterForInteractor>
        extends MoviperRxInteractor {

    /**
     * Remember to call {@link #isPresenterAttached()} before getting the Presenter to avoid
     * {@link NullPointerException}s.
     *
     * @return attached {@link MoviperPresenterForInteractor} subclass instance or
     * null if it's detached (View got destroyed)
     */
    @Nullable
    PresenterType getPresenter();

    boolean isPresenterAttached();

    // TODO: 04.10.2016 move attaching presenter to constructor 
    void attachPresenter(PresenterType presenter);

    void detachPresenter();
}
