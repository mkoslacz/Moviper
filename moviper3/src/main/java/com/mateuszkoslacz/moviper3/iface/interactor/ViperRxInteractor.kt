package com.mateuszkoslacz.moviper3.iface.interactor

import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter

/**
 * Created by mateuszkoslacz on  08.08.2016 Based on lucas.urbas implementation.
 *
 *
 * It's responsible of manipulating data on behalf of Presenter (see [ViperRxPresenter]), ie. saving data to db, getting
 * data from remotes etc.
 *
 *
 * It has no Presenter reference as it should return Observables to asynchronously pass data to
 * Presenter. If you are looking for solution adopted to regular, non-Rx approach, see [ ].
 */
interface ViperRxInteractor {

    /**
     * You can override this to perform an action on presenter attach (ie. set up the resources,
     * delegates etc.). **Don't forget to call super!**
     *
     *
     * Moviper implementation does nothing, but it's here to allow you perform initialization
     * actions on presenter attach  This method is invoked from [ ][ViperRxPresenter.attachView].
     */
    fun attach()

    /**
     * You can override this to perform an action on presenter detach (ie. free the resources etc.).
     * **Don't forget to call super!**
     *
     *
     * This method is called on Presenter detach, ie. when the view has been destroyed.  This method
     * is invoked from [ViperRxPresenter.detachView]}.
     */
    fun detach(retainInstance: Boolean)
}
