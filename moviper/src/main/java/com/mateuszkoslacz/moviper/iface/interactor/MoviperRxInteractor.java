package com.mateuszkoslacz.moviper.iface.interactor;

/**
 * Created by lucas.urbas on 29/08/15.
 * <p>
 * Adapted and modified by mateuszkoslacz on  08.08.2016.
 * <p>
 * It's responsible of manipulating data on behalf of Presenter (see Mosby's
 * {@link com.hannesdorfmann.mosby.mvp.MvpPresenter}). It queries an API, DB etc.
 */
public interface MoviperRxInteractor {

    void onPresenterDetached(boolean retainInstance);

    @Deprecated
    void onPresenterDetached();
}
