package com.mateuszkoslacz.moviper.iface.interactor;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by mateuszkoslacz on  08.08.2016
 * Based on lucas.urbas implementation.
 * </p>
 * It's responsible of manipulating data on behalf of Presenter (see {@link ViperPresenter}).
 * It queries an API, DB etc.
 * </p>
 * It should be used for reactive approach,
 * in which interactor has not any reference to the presenter.
 */
public interface ViperRxInteractor extends CommonViperInteractor {

    /**
     * No attach here. Lifecycle method to keep consistent in interactors.
     * Will be called fi the view has been attached to the presenter.
     * This method will be invoked from <code>ViperPresenter.attachView()</code>
     */
    void attach();
}
