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
        verify(presenter.routing).attach(view)
    }

    @Test
    fun `presenter attaches interactor on attachView`() {
        presenter.attachView(view)
        verify(presenter.interactor).attach()
    }

    @Test
    fun `presenter detaches routing on detachView`() {
        presenter.attachView(view)
        presenter.detachView()
        verify(presenter.routing).detach()
    }

    @Test
    fun `presenter detaches interactor on detachView`() {
        presenter.attachView(view)
        presenter.detachView()
        verify(presenter.interactor).detach()
    }

    @Test
    fun `presenter destroys routing on destroy`() {
        presenter.attachView(view)
        presenter.destroy()
        verify(presenter.routing).destroy()
    }

    @Test
    fun `presenter destroys interactor on destroy`() {
        presenter.attachView(view)
        presenter.destroy()
        verify(presenter.interactor).destroy()
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
    fun `presenter's toString returns its name`() {
        assertEquals(presenter.name, presenter.toString())
    }
}

class TestPresenter : BaseRxPresenter<MvpView, ViperRxInteractor, ViperRxRouting<*>>() {
    override fun createRouting(): ViperRxRouting<*> = mock()
    override fun createInteractor(): ViperRxInteractor = mock()
    override fun initStreams() {

    }
}
