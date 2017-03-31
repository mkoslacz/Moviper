package com.mateuszkoslacz.moviper.presenterbus;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.exception.PresenterAlreadyRegisteredException;
import com.mateuszkoslacz.moviper.base.exception.PresenterInstancesAccessNotEnabled;
import com.mateuszkoslacz.moviper.base.exception.PresentersAccessUtilNotEnabled;
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mateuszkoslacz on 29.10.2016.
 */
public class MoviperTest {

    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    public MoviperTest() {
        RxJavaPlugins.setComputationSchedulerHandler(scheduler -> Schedulers.trampoline());


    }

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
        TestPresenter testPresenter = new TestPresenter();
        Moviper.getInstance().register(testPresenter);
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenters(TestPresenter.class)
                        .test();
        testSubscriber.assertNoErrors();
        testSubscriber.assertComplete();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(testPresenter);
    }

    // TODO this test fails when all tests are run, it succeeds when run alone
    @Test
    public void gettingRegisteredPresenterInstance() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestPresenter testPresenter = new TestPresenter("testPresenter");
        Moviper.getInstance().register(testPresenter);
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenterInstance(TestPresenter.class, "testPresenter")
                        .test();
        testSubscriber.assertNoErrors();
//        testSubscriber.assertNotComplete(); // Maybe protocol says that if it receives the value it does not call oncomplete, but actually it makes testSubscriber completed.
        testSubscriber.assertValue(testPresenter);
    }

    @Test
    public void gettingRegisteredPresenterInstanceOrError() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestPresenter testPresenter = new TestPresenter("testPresenter");
        Moviper.getInstance().register(testPresenter);
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenterInstanceOrError(TestPresenter.class, "testPresenter")
                        .test();
        testSubscriber.assertNoErrors();
//        testSubscriber.assertNotComplete(); // Single protocol says that it has not oncomplete, but actually it makes testSubscriber completed.
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(testPresenter);
    }


    @Test
    public void failureOnRegisteringTwoPresentersWithTheSameNameWhenInstancePresentersAreAllowed() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        final Throwable[] throwable = {null};
        Moviper.getInstance().setErrorHandler(e -> throwable[0] = e);
        TestPresenter testPresenter = new TestPresenter("testPresenter");
        TestPresenter secondTestPresenter = new TestPresenter("testPresenter");
        Moviper.getInstance().register(testPresenter);
        Moviper.getInstance().register(secondTestPresenter);
        Assert.assertTrue(throwable[0] instanceof PresenterAlreadyRegisteredException);
    }

    @Test
    public void gettingPresenterWithNoAccessEnabled() throws Exception {
        mExpectedException.expect(PresentersAccessUtilNotEnabled.class);
        Moviper.getInstance().getPresenters(TestPresenter.class).subscribe();
    }

    @Test
    public void gettingPresenterInstanceWithNoInstanceAccessEnabled() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .build());
        mExpectedException.expect(PresenterInstancesAccessNotEnabled.class);
        Moviper.getInstance()
                .getPresenterInstance(TestPresenter.class, "irrelevant")
                .subscribe();
    }

    @Test
    public void gettingPresenterInstanceWithNoRegisteredPresenter() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenterInstance(TestPresenter.class, "irrelevant")
                        .test();
        testSubscriber.assertNoValues();
        testSubscriber.assertComplete();
    }

    @Test
    public void gettingPresenterInstanceOrErrorWithNoRegisteredPresenter() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenterInstanceOrError(TestPresenter.class, "irrelevant")
                        .test();
        testSubscriber.assertNoValues();
        testSubscriber.assertError(NoSuchElementException.class);
    }

    private static class TestPresenter extends BaseRxPresenter {

        private String name = "name";

        public TestPresenter() {
        }

        public TestPresenter(String name) {
            this.name = name;
        }

        @NonNull
        @Override
        public String getName() {
            return name;
        }

        @NonNull
        @Override
        public ViperRxRouting createRouting() {
            return Mockito.mock(ViperRxRouting.class);
        }

        @NonNull
        @Override
        public ViperRxInteractor createInteractor() {
            return Mockito.mock(ViperRxInteractor.class);
        }
    }
}
