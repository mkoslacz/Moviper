package com.mateuszkoslacz.moviper.presenterbus;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.exception.PresenterAlreadyRegisteredException;
import com.mateuszkoslacz.moviper.base.exception.PresenterInstancesAccessNotEnabled;
import com.mateuszkoslacz.moviper.base.exception.PresentersAccessUtilNotEnabled;
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;

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
        Moviper.getInstance().register(new AnotherClasTestPresenter("anotherClass"));
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenters(TestPresenter.class)
                        .test();
        testSubscriber.assertNoErrors();
        testSubscriber.assertComplete();
        testSubscriber.assertValue(testPresenter);
    }

    @Test
    public void gettingRegisteredPresenterInstance() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        Moviper.getInstance().register(new TestPresenter("another"));
        TestPresenter testPresenter = new TestPresenter("testPresenter");
        Moviper.getInstance().register(testPresenter);
        Moviper.getInstance().register(new AnotherClasTestPresenter("testPresenter"));
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenterInstance(TestPresenter.class, "testPresenter")
                        .test();
        testSubscriber.assertNoErrors();
        testSubscriber.assertValue(testPresenter);
    }

    @Test
    public void gettingRegisteredPresenterInstanceOrError() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        Moviper.getInstance().register(new TestPresenter("another"));
        TestPresenter testPresenter = new TestPresenter("testPresenter");
        Moviper.getInstance().register(testPresenter);
        Moviper.getInstance().register(new AnotherClasTestPresenter("testPresenter"));
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenterInstanceOrError(TestPresenter.class, "testPresenter")
                        .test();
        testSubscriber.assertNoErrors();
        testSubscriber.assertValue(testPresenter);
    }

    @Test
    public void gettingPresenterWithNoRegisteredPresenter() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .build());
        Moviper.getInstance().register(new AnotherClasTestPresenter());
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenters(TestPresenter.class)
                        .test();
        testSubscriber.assertNoValues();
        testSubscriber.assertNoErrors();
        testSubscriber.assertComplete();
    }

    @Test
    public void gettingPresenterInstanceWithNoRegisteredPresenter() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        Moviper.getInstance().register(new TestPresenter("another"));
        Moviper.getInstance().register(new AnotherClasTestPresenter("testPresenter"));
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenterInstance(TestPresenter.class, "testPresenter")
                        .test();
        testSubscriber.assertNoValues();
        testSubscriber.assertNoErrors();
    }

    @Test
    public void gettingPresenterInstanceOrErrorWithNoRegisteredPresenter() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        Moviper.getInstance().register(new TestPresenter("another"));
        Moviper.getInstance().register(new AnotherClasTestPresenter("testPresenter"));
        TestObserver<TestPresenter> testSubscriber =
                Moviper.getInstance()
                        .getPresenterInstanceOrError(TestPresenter.class, "testPresenter")
                        .test();
        testSubscriber.assertNoValues();
        testSubscriber.assertError(NoSuchElementException.class);
    }

    @Test
    public void failureOnRegisteringTwoPresentersWithTheSameNameWhenInstancePresentersAreAllowed() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestSubscriber<Object> testSubscriber = TestSubscriber.create(); // I use it for convenience
        testSubscriber.onSubscribe(SubscriptionHelper.CANCELLED); // workaround to avoid "onSubscribe not called in proper order"
        Moviper.getInstance().setErrorHandler(e -> testSubscriber.onError(e));
        TestPresenter testPresenter = new TestPresenter("testPresenter");
        TestPresenter secondTestPresenter = new TestPresenter("testPresenter");
        Moviper.getInstance().register(testPresenter);
        Moviper.getInstance().register(secondTestPresenter);
        testSubscriber.assertError(PresenterAlreadyRegisteredException.class);
    }

    @Test
    public void noFailureOnRegisteringTwoPresentersWithTheSameNameButOtherClassWhenInstancePresentersAreAllowed() throws Exception {
        Moviper.getInstance().setConfig(new Config.Builder()
                .withPresenterAccessUtilEnabled(true)
                .withInstancePresentersEnabled(true)
                .build());
        TestSubscriber<Object> testSubscriber = TestSubscriber.create(); // I use it for convenience
        testSubscriber.onSubscribe(SubscriptionHelper.CANCELLED); // workaround to avoid "onSubscribe not called in proper order"
        Moviper.getInstance().setErrorHandler(e -> testSubscriber.onError(e));
        TestPresenter testPresenter = new TestPresenter("testPresenter");
        TestPresenter secondTestPresenter = new AnotherClasTestPresenter("testPresenter");
        Moviper.getInstance().register(testPresenter);
        Moviper.getInstance().register(secondTestPresenter);
        testSubscriber.assertNoErrors();
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

    private static class AnotherClasTestPresenter extends TestPresenter {


        public AnotherClasTestPresenter() {
        }

        public AnotherClasTestPresenter(String name) {
            super(name);
        }
    }
}
