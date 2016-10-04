package com.mateuszkoslacz.moviper.iface.presenter.interactor;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;

/**
 * Created by lucas.urbas on 29/08/15.
 * <p>
 * Adapted and modified by mateuszkoslacz on  08.08.2016.
 * <p>
 * It defines presenter interface which Interactor ({@link MoviperInteractor}) needs to communicate
 * with Presenter ({@link com.hannesdorfmann.mosby.mvp.MvpBasePresenter} for proper
 * execution of given tasks. There are mostly callbacks for displaying data from interactor,
 * interactor's error messages etc.
 */
// I prefer readability rather than conventions
public interface MoviperPresenterForInteractor<InteractorType extends MoviperRxInteractor> {

    @Deprecated
    boolean isInteractorAttached();

    /**
     * Remember to call {@link #isInteractorAttached()} before getting the Interactor to avoid
     * {@link NullPointerException}s.
     *
     * @return attached {@link MoviperInteractor} subclass instance or
     * null if it's detached (View got destroyed)
     */
    @NonNull
    InteractorType getInteractor();

    /**
     * Instantiate a Interactor instance here.
     *
     * @return The {@link MoviperInteractor} for this view
     */
    @NonNull
    InteractorType createInteractor();
}
