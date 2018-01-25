package com.mateuszkoslacz.moviper3.base.presenter

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper3.iface.routing.ViperRxRouting
import com.mateuszkoslacz.moviper3.iface.view.ViperView
import com.nhaarman.mockito_kotlin.*
import junit.framework.Assert.*
import org.junit.Test

class BaseRxPresenterTest {

    val view: ViperView = mock()
    val presenter = spy(TestPresenter())

    @Test
    fun `presenter attaches ContextHolder to routing on attachView`() {
        presenter.attachView(view)
        verify(presenter.getRoutingForTesting()).attach(view)
    }

    @Test
    fun `presenter attaches interactor on attachView`() {
        presenter.attachView(view)
        verify(presenter.getInteractorForTesting()).attach()
    }

    @Test
    fun `presenter detaches routing on detachView`() {
        presenter.attachView(view)
        presenter.detachView()
        verify(presenter.getRoutingForTesting()).detach()
    }

    @Test
    fun `presenter detaches interactor on detachView`() {
        presenter.attachView(view)
        presenter.detachView()
        verify(presenter.getInteractorForTesting()).detach()
    }

    @Test
    fun `presenter destroys routing on destroy`() {
        presenter.attachView(view)
        presenter.destroy()
        verify(presenter.getRoutingForTesting()).destroy()
    }

    @Test
    fun `presenter destroys interactor on destroy`() {
        presenter.attachView(view)
        presenter.destroy()
        verify(presenter.getInteractorForTesting()).destroy()
    }

    @Test
    fun `presenter retains compatibility with old detachView on detach`() {
        presenter.detachView()
        verify(presenter).detachView(true)
    }

    @Test
    fun `presenter retains compatibility with old detachView on destroy`() {
        presenter.destroy()
        verify(presenter).detachView(false)
    }

    @Test
    fun `old detachView(true) doesn't have any side effects`() {
        presenter.detachView(true)
        verify(presenter, only()).detachView(retainInstance = true)
        verifyNoMoreInteractions(presenter)
    }

    @Test
    fun `old detachView(false) doesn't have any side effects`() {
        presenter.detachView(false)
        verify(presenter, only()).detachView(retainInstance = false)
    }

    @Test
    fun `presenter's default name contains its full class name`() {
        println(presenter.name)
        assertTrue(presenter.name.contains("com.mateuszkoslacz.moviper3.base.presenter.TestPresenter"))
    }

    @Test
    fun `presenter's default name is unique`() {
        assertFalse(TestPresenter().name == TestPresenter().name)
    }

    @Test
    fun `presenter's default hashcode is unique`() {
        assertFalse(TestPresenter().hashCode() == TestPresenter().hashCode())
    }

    @Test
    fun `presenter's toString returns its name`() {
        assertEquals(presenter.name, presenter.toString())
    }

    @Test
    fun `presenter's equals matches presenters with the same name`() {
        assertEquals(TestNamedPresenter("name"), TestNamedPresenter("name"))
    }

    @Test
    fun `presenters with the same names have the same hashcode`() {
        assertEquals(TestNamedPresenter("name").hashCode(), TestNamedPresenter("name").hashCode())
    }
}

class TestPresenter : BaseRxPresenter<MvpView, ViperRxInteractor, ViperRxRouting<*>>() {

    override fun createRouting(): ViperRxRouting<*> = mock()
    override fun createInteractor(): ViperRxInteractor = mock()
    override fun initStreams() = Unit
    fun getRoutingForTesting() = routing
    fun getInteractorForTesting() = interactor
}

class TestNamedPresenter(override val name: String) : BaseRxPresenter<MvpView, ViperRxInteractor, ViperRxRouting<*>>() {

    override fun createRouting(): ViperRxRouting<*> = mock()
    override fun createInteractor(): ViperRxInteractor = mock()
    override fun initStreams() = Unit
    fun getRoutingForTesting() = routing
    fun getInteractorForTesting() = interactor
}
