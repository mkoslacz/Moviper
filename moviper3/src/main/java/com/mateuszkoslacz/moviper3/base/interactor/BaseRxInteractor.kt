package com.mateuszkoslacz.moviper3.base.interactor


import com.mateuszkoslacz.moviper3.iface.interactor.ViperRxInteractor
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by lucas.urbas on 29/08/15.
 *
 *
 * Adapted and modified by mateuszkoslacz on 21.10.2016.
 *
 *
 * Base Interactor class. (see ViperInteractor)
 *
 *
 * It's responsible for manipulating data on behalf of presenter, ie. saving data to db, getting
 * data from remotes etc.
 *
 *
 * It has no Presenter reference as it should return Observables to asynchronously pass data to
 * Presenter.
 */
abstract class BaseRxInteractor : ViperRxInteractor {

    private val disposables = CompositeDisposable()

    override fun attach() = Unit

    override fun detach(retainInstance: Boolean) = Unit

    override fun detach() = detach(retainInstance = true)

    override fun destroy() {
        detach(false)
        disposables.dispose()
    }
}
