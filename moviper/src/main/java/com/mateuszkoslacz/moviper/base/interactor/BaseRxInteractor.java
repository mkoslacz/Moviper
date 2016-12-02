package com.mateuszkoslacz.moviper.base.interactor;


import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;

/**
 * Created by lucas.urbas on 29/08/15.
 * <p>
 * Adapted and modified by mateuszkoslacz on 21.10.2016.
 * <p>
 * Base Interactor class. (see {@link MoviperInteractor})
 */
public abstract class BaseRxInteractor implements MoviperRxInteractor {

    @Override
    public void onPresenterDetached(boolean retainInstance) {
        onPresenterDetached();
        // stub
    }

    @Override
    @Deprecated
    public void onPresenterDetached(){
        // stub
    }
}
