package com.mateuszkoslacz.moviper.iface.presenter.interactor;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.iface.interactor.CommonViperInteractor;
import com.mateuszkoslacz.moviper.iface.interactor.ViperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by mateuszkoslacz on  08.08.2016.
 * <p>
 * It defines presenter interface which Interactor ({@link ViperInteractor}) needs to communicate
 * with Presenter ({@link ViperPresenter} for proper execution of given tasks. There are mostly
 * callbacks for displaying data from interactor, interactor's error messages etc.
 */
public interface ViperPresenterForInteractor<InteractorType extends CommonViperInteractor> {

    /**
     * @return attached {@link ViperInteractor} subclass instance or
     * null if it's detached (View got destroyed)
     */
    @NonNull
    InteractorType getInteractor();

    /**
     * Instantiate a Interactor instance here.
     *
     * @return The {@link ViperInteractor} for this view
     */
    @NonNull
    InteractorType createInteractor();
}
