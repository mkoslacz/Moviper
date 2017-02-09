package com.mateuszkoslacz.moviper.base.interactor;


import com.mateuszkoslacz.moviper.iface.interactor.ViperInteractor;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;

/**
 * Created by lucas.urbas on 29/08/15.
 * <p>
 * Adapted and modified by mateuszkoslacz on 21.10.2016.
 * <p>
 * Base Interactor class. (see {@link ViperInteractor})
 * <p>
 * It's responsible for manipulating data on behalf of presenter, ie. saving data to db, getting
 * data from remotes etc.
 * <p>
 * It has no Presenter reference as it should return Observables to asynchronously pass data to
 * Presenter. If you are looking for solution adopted to regular, non-Rx approach, see {@link
 * BaseRxInteractor}.
 */
public abstract class BaseRxInteractor implements ViperRxInteractor {

    @Override
    public void attach() {

    }

    @Override
    public void detach(boolean retainInstance) {

    }
}
