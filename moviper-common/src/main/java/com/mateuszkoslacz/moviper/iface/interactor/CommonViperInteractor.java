package com.mateuszkoslacz.moviper.iface.interactor;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by tomasznajda on 16.12.2016. <br> Based on lucas.urbas implementation.
 * <p>
 * Base interface of all Interactors. Interactor is  responsible of manipulating data on behalf of
 * Presenter (see {@link ViperPresenter}), ie. saving data to db, getting
 * data from remotes etc.
 */

public interface CommonViperInteractor {

    /**
     * You can override this to perform an action on presenter detach (ie. free the resources etc.).
     * <b>Don't forget to call super!</b>
     * <p>
     * This method is called on Presenter detach, ie. when the view has been destroyed.  This method
     * is invoked from {@link ViperPresenter#detachView(boolean)}}.
     */
    void detach(boolean retainInstance);
}
