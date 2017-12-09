package com.mateuszkoslacz.moviper3.base.presenter

import com.mateuszkoslacz.moviper3.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper3.iface.routing.ViperRxRouting
import com.mateuszkoslacz.moviper3.iface.view.ViperView
import com.mateuszkoslacz.moviper3.presenterbus.Config
import com.mateuszkoslacz.moviper3.presenterbus.Moviper
import com.nhaarman.mockito_kotlin.clearInvocations
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import io.reactivex.Observable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Test
import org.mockito.Mockito
import java.util.concurrent.TimeUnit

class BaseRxPresenterRxTest {

    interface TestView : ViperView {
        fun testDisplay(number: Long)
    }

    val view: TestView = mock()

    class TestPresenter : BaseRxPresenter<TestView, ViperRxInteractor, ViperRxRouting<*>>() {
        val scheduler = TestScheduler()

        override fun createRouting(): ViperRxRouting<*> = mock()
        override fun createInteractor(): ViperRxInteractor = mock()

        override fun attachView(incomingView: TestView) {
            super.attachView(incomingView)

            disposables.add(
                    Observable.interval(100, TimeUnit.MILLISECONDS, scheduler)
                            .subscribeBy(onNext = { view?.testDisplay(it) }))
        }
    }

    val presenter = TestPresenter()

    init {
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        Moviper.instance.setConfig(Config(isPresenterAccessUtilEnabled = true, isInstancePresentersEnabled = true))
    }

    @After
    fun cleanup() {
        Moviper.instance.unregisterAll()
    }

    @Test
    fun `presenter disposes all disposables on destroy`() {
        presenter.attachView(view)
        presenter.scheduler.advanceTimeBy(301, TimeUnit.MILLISECONDS)
        verify(view).testDisplay(0)
        verify(view).testDisplay(1)
        verify(view).testDisplay(2)
        presenter.destroy()
        presenter.scheduler.advanceTimeBy(301, TimeUnit.MILLISECONDS)
        verifyNoMoreInteractions(view)
        clearInvocations(view)
        presenter.attachView(view)
        presenter.scheduler.advanceTimeBy(301, TimeUnit.MILLISECONDS)
        verify(view).testDisplay(0)
        verify(view).testDisplay(1)
        verify(view).testDisplay(2)
    }

    @Test
    fun `presenter doesn't dispose disposables on detach`() {
        presenter.attachView(view)
        presenter.scheduler.advanceTimeBy(301, TimeUnit.MILLISECONDS)
        verify(view).testDisplay(0)
        verify(view).testDisplay(1)
        verify(view).testDisplay(2)
        presenter.detachView()
        presenter.scheduler.advanceTimeBy(301, TimeUnit.MILLISECONDS)
        verifyNoMoreInteractions(view)
        presenter.attachView(view) // TODO what will happen on reattaching view to the presenter? won't all of the observables from attachView be recreated?
        presenter.scheduler.advanceTimeBy(301, TimeUnit.MILLISECONDS)
        verify(view).testDisplay(6)
        verify(view).testDisplay(7)
        verify(view).testDisplay(8)
        verifyNoMoreInteractions(view) // TODO it will! we need to create new streams only when presenter is attached for the first time
        // TODO moreover it will be registered to IPC twice in such case!
    }

    @Test
    fun `presenter registers itself on Moviper IPC on attachView`() {
        presenter.attachView(view)
        Moviper.instance.getPresenterInstanceOrError(TestPresenter::class.java, presenter.name).test().assertValue(presenter)
    }

    @Test
    fun `presenter unregisters itself on Moviper IPC on destroy`() {
        presenter.attachView(view)
        Moviper.instance.getPresenterInstanceOrError(TestPresenter::class.java, presenter.name).test().assertValue(presenter)
        presenter.destroy()
        Moviper.instance.getPresenters(TestPresenter::class.java).test().assertNoValues()
    }

    @Test
    fun `presenter doesn't unregister itself on Moviper IPC on detach`() {
        presenter.attachView(view)
        Moviper.instance.getPresenterInstanceOrError(TestPresenter::class.java, presenter.name).test().assertValue(presenter)
        presenter.detachView()
        Moviper.instance.getPresenterInstanceOrError(TestPresenter::class.java, presenter.name).test().assertValue(presenter)
    }
}
