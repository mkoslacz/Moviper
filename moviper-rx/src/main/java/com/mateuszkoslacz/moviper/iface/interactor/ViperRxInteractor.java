package com.mateuszkoslacz.moviper.iface.interactor;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by mateuszkoslacz on  08.08.2016 Based on lucas.urbas implementation.
 * <p>
 * It's responsible of manipulating data on behalf of Presenter (see {@link ViperPresenter}), ie. saving data to db, getting
 * data from remotes etc.
 * <p>
 * It has no Presenter reference as it should return Observables to asynchronously pass data to
 * Presenter. If you are looking for solution adopted to regular, non-Rx approach, see {@link
 * BaseRxInteractor}.
 */
public interface ViperRxInteractor extends CommonViperInteractor {

    /**
     * You can override this to perform an action on presenter attach (ie. set up the resources,
     * delegates etc.). <b>Don't forget to call super!</b>
     * <p>
     * Moviper implementation does nothing, but it's here to allow you perform initialization
     * actions on presenter attach  This method is invoked from {@link
     * ViperPresenter#attachView(MvpView)}.
     */
    void attach();
}
