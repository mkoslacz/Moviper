/*
 * Copyright 2017 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.mateuszkoslacz.moviper3.base.presenter

import android.content.Context
import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.mateuszkoslacz.moviper3.base.interactor.BaseRxInteractor
import com.mateuszkoslacz.moviper3.base.routing.BaseRxRouting
import com.mateuszkoslacz.moviper3.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper3.iface.routing.ViperRxRouting
import com.mateuszkoslacz.moviper3.iface.view.ViperView

import org.junit.Assert
import org.junit.Test

import junit.framework.Assert.assertEquals

/**
 * @author Hannes Dorfmann
 */
class MosbyMvpBasePresenterTest {

    class TestPresenter : BaseRxPresenter<MvpView, ViperRxInteractor, ViperRxRouting<*>>(){
        override fun createRouting(): ViperRxRouting<*> {
            return object : BaseRxRouting<Context>(){}
        }

        override fun createInteractor(): ViperRxInteractor {
            return object : BaseRxInteractor(){}
        }
    }

    @Test
    fun testAttachView() {
        val presenter = TestPresenter()
        val mvpView = object : ViperView {
            override fun getContext(): Context? = null
            override val args: Bundle? = null
        }

        Assert.assertFalse(presenter.isViewAttached)
        presenter.attachView(mvpView)
        Assert.assertTrue(presenter.isViewAttached)
    }

    @Test
    fun testDetachView() {
        val presenter = MvpBasePresenter<MvpView>()
        val mvpView = object : MvpView {

        }

        presenter.attachView(mvpView)
        presenter.detachView()
        presenter.destroy()
        assertViewNotAttachedAndNull(presenter)
    }

    @Test
    fun testGetView() {
        val presenter = MvpBasePresenter<MvpView>()
        val mvpView = object : MvpView {

        }

        Assert.assertNull(presenter.view)
        presenter.attachView(mvpView)
        Assert.assertNotNull(presenter.view)
    }

    @Test
    fun testOnDestroy() {
        val presenter = MvpBasePresenter<MvpView>()
        val view = object : MvpView {

        }

        assertViewNotAttachedAndNull(presenter)
        presenter.attachView(view)

        assertViewAttachedAndNotNull(presenter)
        assertEquals(presenter.view, view)

        presenter.detachView()
        assertViewNotAttachedAndNull(presenter)

        presenter.attachView(view)
        presenter.detachView()
        presenter.destroy()
        assertViewNotAttachedAndNull(presenter)
    }

    private fun assertViewAttachedAndNotNull(presenter: MvpBasePresenter<*>) {
        Assert.assertTrue(presenter.isViewAttached)
        Assert.assertNotNull(presenter.view)
    }

    private fun assertViewNotAttachedAndNull(presenter: MvpBasePresenter<*>) {
        Assert.assertFalse(presenter.isViewAttached)
        Assert.assertNull(presenter.view)
    }
}
