package com.mateuszkoslacz.moviper.iface.presenter.interactor;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.iface.interactor.CommonViperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by mateuszkoslacz on  08.08.2016.
 * <p>
 * Interface used by Interactor (ViperInteractor) to communicate with Presenter ({@link
 * ViperPresenter}. There are mostly callbacks for displaying data from interactor, interactor's
 * error messages etc.
 */
public interface ViperPresenterForInteractor<InteractorType extends CommonViperInteractor> {

    /**
     * @return attached ViperInteractor.
     */
    @NonNull
    InteractorType getInteractor();

    /**
     * Override this and return a instantiated Interactor object here.
     *
     * @return The ViperInteractor for this view
     */
    @NonNull
    InteractorType createInteractor();
}
