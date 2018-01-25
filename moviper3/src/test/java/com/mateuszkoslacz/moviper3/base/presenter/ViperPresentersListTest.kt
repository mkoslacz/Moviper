package com.mateuszkoslacz.moviper3.base.presenter

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter
import com.mateuszkoslacz.moviper3.iface.routing.ViperRxRouting
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.*
import org.junit.Test

class ViperPresentersListTest {

    val presenter1: ViperRxPresenter<MvpView> = mock()
    val presenter2: ViperRxPresenter<MvpView> = mock()
    val presenter3: ViperRxPresenter<MvpView> = mock()

    val presentersList = ViperPresentersList(presenter1, presenter2, presenter3)

    @Test
    fun `attachView attaches all presenters in the list`() {
        val view: MvpView = mock()
        presentersList.attachView(view)
        verify(presenter1).attachView(view)
        verifyNoMoreInteractions(presenter1)
        verify(presenter2).attachView(view)
        verifyNoMoreInteractions(presenter2)
        verify(presenter3).attachView(view)
        verifyNoMoreInteractions(presenter3)
    }

    @Test
    fun `old detachView detaches all presenters in the list`() {
        presentersList.detachView(true)
        verify(presenter1).detachView(true)
        verifyNoMoreInteractions(presenter1)
        verify(presenter2).detachView(true)
        verifyNoMoreInteractions(presenter2)
        verify(presenter3).detachView(true)
        verifyNoMoreInteractions(presenter3)
    }

    @Test
    fun `old detachView detaches all presenters in the list with false`() {
        presentersList.detachView(false)
        verify(presenter1).detachView(false)
        verifyNoMoreInteractions(presenter1)
        verify(presenter2).detachView(false)
        verifyNoMoreInteractions(presenter2)
        verify(presenter3).detachView(false)
        verifyNoMoreInteractions(presenter3)
    }

    @Test
    fun `detachView attaches all presenters in the list`() {
        presentersList.detachView()
        verify(presenter1).detachView()
        verifyNoMoreInteractions(presenter1)
        verify(presenter2).detachView()
        verifyNoMoreInteractions(presenter2)
        verify(presenter3).detachView()
        verifyNoMoreInteractions(presenter3)
    }

    @Test
    fun `destroy destroys all presenters in the list`() {
        presentersList.destroy()
        verify(presenter1).destroy()
        verifyNoMoreInteractions(presenter1)
        verify(presenter2).destroy()
        verifyNoMoreInteractions(presenter2)
        verify(presenter3).destroy()
        verifyNoMoreInteractions(presenter3)
    }

    @Test
    fun `name contains all presenters' names`() {
        whenever(presenter1.name).thenReturn("presenter1")
        whenever(presenter2.name).thenReturn("presenter2")
        whenever(presenter3.name).thenReturn("presenter3")
        assertTrue(presentersList.name.contains("presenter1"))
        assertTrue(presentersList.name.contains("presenter2"))
        assertTrue(presentersList.name.contains("presenter3"))
    }

    @Test
    fun `equals matches lists with the same content`(){
        val presentersList = ViperPresentersList(TestNamedPresenter("pres1"),
                TestNamedPresenter("pres2"), TestNamedPresenter("pres3"))
        val anotherPresentersList = ViperPresentersList(TestNamedPresenter("pres1"),
                TestNamedPresenter("pres2"), TestNamedPresenter("pres3"))
        assertEquals(presentersList, anotherPresentersList)
    }

    @Test
    fun `equals doesn't matches lists with the different content`(){
        val presentersList = ViperPresentersList(TestNamedPresenter("pres1"),
                TestNamedPresenter("pres2"), TestNamedPresenter("pres3"))
        val anotherPresentersList = ViperPresentersList(TestNamedPresenter("pres1"),
                TestNamedPresenter("pres2"), TestNamedPresenter("pres4"))
        assertNotEquals(presentersList, anotherPresentersList)
    }

    @Test
    fun `hashcodes for lists with the same content are the same`(){
        val presentersList = ViperPresentersList(TestNamedPresenter("pres1"),
                TestNamedPresenter("pres2"), TestNamedPresenter("pres3"))
        val anotherPresentersList = ViperPresentersList(TestNamedPresenter("pres1"),
                TestNamedPresenter("pres2"), TestNamedPresenter("pres3"))
        assertEquals(presentersList.hashCode(), anotherPresentersList.hashCode())
    }

    @Test
    fun `hashcodes for lists with the same content are different`(){
        val presentersList = ViperPresentersList(TestNamedPresenter("pres1"),
                TestNamedPresenter("pres2"), TestNamedPresenter("pres3"))
        val anotherPresentersList = ViperPresentersList(TestNamedPresenter("pres1"),
                TestNamedPresenter("pres2"), TestNamedPresenter("pres4"))
        assertNotEquals(presentersList.hashCode(), anotherPresentersList.hashCode())
    }
}

