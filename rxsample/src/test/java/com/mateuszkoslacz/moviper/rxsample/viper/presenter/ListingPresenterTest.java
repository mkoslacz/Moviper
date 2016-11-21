package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.app.Activity;

import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.utils.RxAndroidSchedulersOverrideRule;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.ListingActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.observers.TestSubscriber;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;
import rx.subjects.TestSubject;

import static org.junit.Assert.*;

/**
 * Created by mateuszkoslacz on 17.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListingPresenterTest {

    // it doesn't seem to work
//    @Rule
//    public final RxAndroidSchedulersOverrideRule mOverrideRule = new RxAndroidSchedulersOverrideRule();

    @Mock
    private ListingInteractor mInteractor;

    @Mock
    private ListingRouting mRouting;

    @Mock
    private ListingActivity mView;

    @InjectMocks
    private ListingPresenter mPresenter = new ListingPresenter(mView);

    @Before
    public void setUpPresenter(){
        mPresenter.attachView(mView);
    }


    @Test
    public void onViewCreated() throws Exception {
        List<User> users = new ArrayList<>();
        TestSubject<List<User>> subject = TestSubject.create(new TestScheduler());
        Mockito.when(mInteractor.getUserList()).thenReturn(subject);
        mPresenter.onViewCreated();
        Mockito.verify(mView).showLoading();
        subject.onNext(users);
        Mockito.verify(mInteractor).getUserList();
        Mockito.verify(mView).setUserList(users);
        Mockito.verify(mView).showContent();
    }

    @Test
    public void onItemClicked() throws Exception {
        List<User> users = new ArrayList<>();
        TestScheduler scheduler = new TestScheduler();
        TestSubject<List<User>> subject = TestSubject.create(scheduler);
        Mockito.when(mInteractor.getUserList()).thenReturn(subject);
        // adjust tests to make printlns in subscribe appear
        // http://code.hootsuite.com/unit-testing-with-rxandroid-and-rxjava/
        mInteractor.getUserList()
                .subscribeOn(scheduler)
                .observeOn(scheduler)
                .subscribe(
                users1 -> {
                    System.out.println("onNext: " + users1);
                },
                throwable -> {
                    System.out.println("onError: " + throwable.getLocalizedMessage());
                    throwable.printStackTrace();
                },
                () -> {
                    System.out.println("onCompleted");
                }
        );
        subject.onNext(users);
    }
}