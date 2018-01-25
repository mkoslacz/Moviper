package com.mateuszkoslacz.moviper3.presenterbus

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper3.exception.PresenterNotFoundException
import com.mateuszkoslacz.moviper3.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper3.iface.routing.ViperRxRouting
import com.nhaarman.mockito_kotlin.mock
import org.junit.After
import org.junit.Before
import org.junit.Test

class MoviperTest {

    @Before
    fun setup() {
        Moviper.setConfig(Config(
                isPresenterAccessUtilEnabled = true,
                isInstancePresentersEnabled = true))
    }

    @After
    fun clear() = Moviper.unregisterAll()

    @Test
    fun `getPresenters gets new presenters`() {
        Moviper.register(TestPresenter("pres1"))
        Moviper.register(TestPresenter("pres2"))
        Moviper.register(TestPresenter("pres3"))
        Moviper.register(TestPresenter("pres4"))
        Moviper.getPresenters(TestPresenter::class.java)
                .test()
                .assertValueSet(listOf(TestPresenter("pres1"), TestPresenter("pres2"),
                        TestPresenter("pres3"), TestPresenter("pres4")))
                .assertNoErrors()
                .assertComplete()
    }

    @Test
    fun `getPresenterOrError gets a presenter`() {
        val registeredPresenter = TestPresenter()
        Moviper.register(registeredPresenter)
        Moviper.getPresenterInstanceOrError(TestPresenter::class.java, "default")
                .test()
                .assertValue { it == TestPresenter() }
                .assertNoErrors()
                .assertComplete()
    }

    @Test
    fun `getPresenterOrError throws error when given new presenter doesn't exist`() {
        Moviper.getPresenterInstanceOrError(TestPresenter::class.java, "default")
                .test()
                .assertNoValues()
                .assertError { (it is PresenterNotFoundException) }
    }

    @Test
    fun `getPresenterInstance gets a new presenter`() {
        val registeredPresenter = TestPresenter()
        Moviper.register(registeredPresenter)
        Moviper.getPresenterInstance(TestPresenter::class.java, "default")
                .test()
                .assertValue { it == TestPresenter() }
                .assertNoErrors()
                .assertComplete()
    }

    @Test
    fun `getPresenterInstance doesn't throw error when new presenter doesnt exist`() {
        Moviper.getPresenterInstance(TestPresenter::class.java, "default")
                .test()
                .assertNoValues()
                .assertNoErrors()
                .assertComplete()
    }
}

class TestPresenter(override val name: String = "default")
    : BaseRxPresenter<MvpView, ViperRxInteractor, ViperRxRouting<*>>() {
    override fun createRouting(): ViperRxRouting<*> = mock()
    override fun createInteractor(): ViperRxInteractor = mock()
    override fun initStreams() = Unit
}
