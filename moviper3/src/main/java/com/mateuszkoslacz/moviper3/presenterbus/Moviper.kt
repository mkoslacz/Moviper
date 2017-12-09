package com.mateuszkoslacz.moviper3.presenterbus

import android.app.Application
import android.support.annotation.VisibleForTesting
import android.util.Log

import com.mateuszkoslacz.moviper3.exception.PresenterAlreadyRegisteredException
import com.mateuszkoslacz.moviper3.exception.PresenterInstancesAccessNotEnabled
import com.mateuszkoslacz.moviper3.exception.PresenterNotFoundException
import com.mateuszkoslacz.moviper3.exception.PresentersAccessUtilNotEnabled
import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter
import java.util.concurrent.CopyOnWriteArrayList

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject


/**
 * Created by mateuszkoslacz on 24.10.2016.
 */
class Moviper private constructor() {
    private var errorHandler: (Throwable) -> Unit = { e : Throwable -> Log.e(TAG, "IPC default error handler: ", e) }

    private var config = Config()

    // for every presenter complete lifecycle we do two writes (save and remove), and
    // n reads where n is the size of the presenters list.
    // for every external call we do n reads where n is the size of the presenters list.
    // that makes
    // TODO: 28.10.2016 reconsider no-checking if presenter exists
    private val presenters = CopyOnWriteArrayList<ViperRxPresenter<*>>()

    private val registerSynchronizer = PublishSubject.create<MoviperBundle>()

    init {
        registerSynchronizer
                .subscribeOn(Schedulers.computation())
                .doOnNext(Consumer<MoviperBundle> { this.routeMoviperBundle(it) })
                .doOnError { throwable -> errorHandler.invoke(throwable) }
                .retry()
                .subscribe()
    }

    fun setErrorHandler(handler: (Throwable) -> Unit) {
        this.errorHandler = handler
    }

    /**
     * Use it in [Application.onCreate] to setup IPC and IPC Instance Presenter Access to
     * let you make use of [.getPresenters] and [.getPresenterInstance].
     */
    fun setConfig(config: Config) {
        this.config = config
    }

    fun register(presenter: ViperRxPresenter<*>) {
        if (config.isPresenterAccessUtilEnabled) {
            registerSynchronizer.onNext(MoviperBundle(presenter, true))
        }
    }

    fun unregister(presenter: ViperRxPresenter<*>) {
        if (config.isPresenterAccessUtilEnabled) {
            registerSynchronizer.onNext(MoviperBundle(presenter, false))
        }
    }

    private fun routeMoviperBundle(bundle: MoviperBundle) {
        if (bundle.isRegister) {
            if (config.isInstancePresentersEnabled && presenters.contains(bundle.presenter))
                throw PresenterAlreadyRegisteredException(bundle.presenter)
            registerSync(bundle.presenter)
        } else {
            unregisterSync(bundle.presenter)
        }
    }

    /**
     * <dl>
     * <dt>**Scheduler:**</dt>
     * <dd>`fromIterable` does not operate by default on a particular [Scheduler].</dd>
    </dl> *
     *
     * Make sure that you have enabled IPC Instance Presenter Access by using [ ][.setConfig] with [Config.Builder.withPresenterAccessUtilEnabled] set
     * to true to avoid [PresenterInstancesAccessNotEnabled] exception being thrown.
     *
     * @param presenterTypeClass class of presenters you want to get
     * @return [Observable] that emits all (from zero to n) registered presenters of given
     * class.
     */
    fun <PresenterType : ViperRxPresenter<*>> getPresenters(
            presenterTypeClass: Class<PresenterType>): Observable<PresenterType> {
        if (!config.isPresenterAccessUtilEnabled) throw PresentersAccessUtilNotEnabled()
        return Observable.fromIterable<ViperRxPresenter<*>>(presenters)
                .filter { viperPresenter -> viperPresenter.javaClass == presenterTypeClass }
                .cast(presenterTypeClass)
    }


    private fun <PresenterType : ViperRxPresenter<*>> getPresenterInstanceObservable(
            presenterTypeClass: Class<PresenterType>, name: String): Observable<PresenterType> {
        if (!config.isInstancePresentersEnabled) throw PresenterInstancesAccessNotEnabled()
        return getPresenters(presenterTypeClass)
                .filter { moviperPresenter -> moviperPresenter.name == name }
    }

    /**
     * It returns a given Presenter instance wrapped in the [Maybe].
     *
     * <dl>
     * <dt>**Scheduler:**</dt>
     * <dd>`fromIterable` does not operate by default on a particular [Scheduler].</dd>
    </dl> *
     *
     * Make sure that you have fulfilled the requirements of ue the general IPC ([ ][.getPresenters].
     *
     *
     * Make sure that you have enabled IPC Instance Presenter Access by using [ ][.setConfig] with [Config.Builder.withInstancePresentersEnabled] set to
     * true to avoid [PresenterInstancesAccessNotEnabled] exception being thrown.
     *
     *
     * If you create two or more presenters with the same name (making [ViperRxPresenter.getName]
     * method returns the the same name for them) with the IPC Instance Presenters Access
     * enabled, a [PresenterAlreadyRegisteredException] is thrown. By default [ViperRxPresenter.getName]
     * method returns unique names.
     *
     * @param presenterTypeClass class of presenter you want to get
     * @param name               name of a presenter you want to get here. You shall set it up by
     * returning proper name in [ViperRxPresenter.getName].
     * @return [Maybe] that emits (or not) Presenter instance of given name and class.
     */
    fun <PresenterType : ViperRxPresenter<*>> getPresenterInstance(
            presenterTypeClass: Class<PresenterType>, name: String): Maybe<PresenterType> {
        return getPresenterInstanceObservable(presenterTypeClass, name)
                .firstElement()
    }

    /**
     * It returns a given Presenter instance wrapped in the [Single] or error if not found.
     *
     * <dl>
     * <dt>**Scheduler:**</dt>
     * <dd>`fromIterable` does not operate by default on a particular [Scheduler].</dd>
    </dl> *
     *
     * Make sure that you have fulfilled the requirements of ue the general IPC ([ ][.getPresenters].
     *
     *
     * Make sure that you have enabled IPC Instance Presenter Access by using [ ][.setConfig] with [Config.Builder.withInstancePresentersEnabled] set to
     * true to avoid [PresenterInstancesAccessNotEnabled] exception being thrown.
     *
     *
     * If you create two or more presenters with the same name (making [ViperRxPresenter.getName]
     * method returns the the same name for them) with the IPC Instance Presenters Access
     * enabled, a [PresenterAlreadyRegisteredException] is thrown. By default [ViperRxPresenter.getName]
     * method returns unique names.
     *
     * @param presenterTypeClass class of presenter you want to get
     * @param name               name of a presenter you want to get here. You shall set it up by
     * returning proper name in [ViperRxPresenter.getName].
     * @return [Single] that emits Presenter instance of given name and class or throws a
     * [java.util.NoSuchElementException].
     */
    fun <PresenterType : ViperRxPresenter<*>> getPresenterInstanceOrError(
            presenterTypeClass: Class<PresenterType>, name: String): Single<PresenterType> {
        return getPresenterInstanceObservable(presenterTypeClass, name)
                .firstElement()
                .doOnComplete { throw PresenterNotFoundException(presenterTypeClass, name) }
                .toSingle()
    }

    private fun registerSync(presenter: ViperRxPresenter<*>) {
        presenters.add(presenter)
    }

    private fun unregisterSync(presenter: ViperRxPresenter<*>) {
        presenters.remove(presenter)
    }

    @VisibleForTesting
    fun unregisterAll() {
        presenters.clear()
    }

    private inner class MoviperBundle(val presenter: ViperRxPresenter<*>, val isRegister: Boolean)

    companion object {

        private val TAG = "Moviper"

        val instance = Moviper()
    }

}
