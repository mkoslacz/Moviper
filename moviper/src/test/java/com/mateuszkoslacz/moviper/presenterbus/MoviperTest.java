package com.mateuszkoslacz.moviper.presenterbus;

import com.mateuszkoslacz.moviper.base.exception.PresenterAlreadyRegisteredException;
import com.mateuszkoslacz.moviper.base.exception.PresenterInstancesAccessNotEnabled;
import com.mateuszkoslacz.moviper.base.exception.PresentersAccessUtilNotEnabled;
import com.mateuszkoslacz.moviper.base.presenter.MoviperBasePresenter;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;

import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;

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

    @Test
    public void getInstance() throws Exception {
        assertNotNull(Moviper.getInstance());
    }

    @Test
    public void gettingRegisteredPresenter() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .build());
        TestSubscriber<TestPresenter> testSubscriber = TestSubscriber.create();
        TestPresenter mockPresenter= Mockito.mock(TestPresenter.class);
        Moviper.getInstance().register(mockPresenter);
        Moviper.getInstance().getPresenters(TestPresenter.class)
                .subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        assertEquals(testSubscriber.getOnNextEvents().size(), 1);
        assertSame(testSubscriber.getOnNextEvents().get(0), mockPresenter);
    }

    @Test
    public void gettingRegisteredPresenterInstance() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestSubscriber<TestPresenter> testSubscriber = TestSubscriber.create();
        TestPresenter mockPresenter= Mockito.mock(TestPresenter.class);
        Mockito.when(mockPresenter.getName()).thenReturn("testPresenter");
        Moviper.getInstance().register(mockPresenter);
        Moviper.getInstance().getPresenterInstance(TestPresenter.class, "testPresenter")
                .subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        assertEquals(testSubscriber.getOnNextEvents().size(), 1);
        assertSame(testSubscriber.getOnNextEvents().get(0), mockPresenter);
    }

    @Test
    public void failureOnRegisteringTwoPresentersWithTheSameNameWhenInstancePresentersAreAllowed() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestPresenter mockPresenter = new TestPresenter();
        TestPresenter secondMockPresenter= new TestPresenter();
        Moviper.getInstance().register(mockPresenter);
        mExpectedException.expect(OnErrorNotImplementedException.class); // TODO how to better handle unwraped rx exceptions?
        Moviper.getInstance().register(secondMockPresenter);
    }

    @Test
    public void gettingPresenterWithNoAccesEnabled() throws Exception {
        mExpectedException.expect(PresentersAccessUtilNotEnabled.class);
        Moviper.getInstance().getPresenters(TestPresenter.class).subscribe();
    }

    @Test
    public void gettingPresenterInstanceWithNoAccesEnabled() throws Exception {
        mExpectedException.expect(PresenterInstancesAccessNotEnabled.class);
        Moviper.getInstance()
                .getPresenterInstance(TestPresenter.class, MoviperPresenter.DEFAULT_NAME)
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

    public static class TestPresenter extends MoviperBasePresenter implements MoviperPresenter{

    }

}