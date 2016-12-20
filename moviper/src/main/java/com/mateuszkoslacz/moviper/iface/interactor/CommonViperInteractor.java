package com.mateuszkoslacz.moviper.iface.interactor;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by tomasznajda on 16.12.2016.
 * Based on lucas.urbas implementation.
 * </p>
 * It's responsible of manipulating data on behalf of Presenter (see {@link ViperPresenter}).
 * It queries an API, DB etc.
 */

public interface CommonViperInteractor {

    /**
     * Detach presenter ({@link ViperInteractor}) from this routing.
     * In ({@link ViperRxInteractor}) is used to keep consistent in lifecycle methods.
     * Will be called if the view has been destroyed.
     * This method will be invoked from <code>ViperPresenter.detachView()</code>
     */
    void detach(boolean retainInstance);
}
