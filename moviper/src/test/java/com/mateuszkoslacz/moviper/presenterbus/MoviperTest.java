package com.mateuszkoslacz.moviper.presenterbus;

import com.mateuszkoslacz.moviper.base.exception.PresenterInstancesAccessNotEnabled;
import com.mateuszkoslacz.moviper.base.exception.PresentersAccessUtilNotEnabled;
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;


import io.reactivex.observers.TestObserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Created by mateuszkoslacz on 29.10.2016.
 */
public class MoviperTest {

    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        // reset Moviper config to default before each test
        Moviper.getInstance().setConfig(new Config.Builder().build());
    }

    @After
    public void clear() throws Exception {
        Moviper.getInstance().unregisterAll();
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(Moviper.getInstance());
    }

    @Test
    public void gettingRegisteredPresenter() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .build());
        TestObserver<TestPresenter> testSubscriber = TestObserver.create();
        TestPresenter mockPresenter = Mockito.mock(TestPresenter.class);
        Moviper.getInstance().register(mockPresenter);
        Moviper.getInstance().getPresenters(TestPresenter.class)
                .subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();
        testSubscriber.assertComplete();
        assertEquals(1, testSubscriber.valueCount());
        assertSame(testSubscriber.values().get(0), mockPresenter);
    }

    @Test
    public void gettingRegisteredPresenterInstance() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestObserver<TestPresenter> testSubscriber = TestObserver.create();
        TestPresenter mockPresenter = Mockito.mock(TestPresenter.class);
        Mockito.when(mockPresenter.getName()).thenReturn("testPresenter");
        Moviper.getInstance().register(mockPresenter);
        Moviper.getInstance().getPresenterInstance(TestPresenter.class, "testPresenter")
                .subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();
        testSubscriber.assertComplete();
        assertEquals(1, testSubscriber.valueCount());
        assertSame(testSubscriber.values().get(0), mockPresenter);
    }

    @Test
    public void failureOnRegisteringTwoPresentersWithTheSameNameWhenInstancePresentersAreAllowed() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestPresenter mockPresenter = Mockito.mock(TestPresenter.class);
        TestPresenter secondMockPresenter = Mockito.mock(TestPresenter.class);
        Moviper.getInstance().register(mockPresenter);
        Moviper.getInstance().register(secondMockPresenter);
    }

    @Test
    public void gettingPresenterWithNoAccessEnabled() throws Exception {
        mExpectedException.expect(PresentersAccessUtilNotEnabled.class);
        Moviper.getInstance().getPresenters(TestPresenter.class).subscribe();
    }

    @Test
    public void gettingPresenterInstanceWithNoAccessEnabled() throws Exception {
        mExpectedException.expect(PresenterInstancesAccessNotEnabled.class);
        Moviper.getInstance()
                .getPresenterInstance(TestPresenter.class, ViperPresenter.DEFAULT_NAME)
                .subscribe();
    }

    @Test
    public void unregister() throws Exception {

    }

    @Test
    public void getPresenters() throws Exception {

    }

    @Test
    public void getPresenterInstance() throws Exception {

    }

    private static abstract class TestPresenter extends BaseRxPresenter {
    }
}
