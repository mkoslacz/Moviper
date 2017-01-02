package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.utils.RxAndroidSchedulersOverrideRule;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.ListingActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.schedulers.TestScheduler;
import rx.subjects.PublishSubject;
import rx.subjects.TestSubject;

import static org.mockito.Mockito.*;

/**
 * Created by mateuszkoslacz on 17.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListingPresenterTest {

    @Rule
    public final RxAndroidSchedulersOverrideRule mOverrideRule = new RxAndroidSchedulersOverrideRule();

    @Mock
    protected ListingInteractor mInteractor;

    @Mock
    protected ListingRouting mRouting;

    @Mock
    protected ListingActivity mView;

    @InjectMocks
    protected ListingPresenter mPresenter = new ListingPresenter();
    private PublishSubject<User> mUserClicks;

    @Before
    public void setUpViewMock(){
        mUserClicks = PublishSubject.create();
        Mockito.when(mView.getUserClicks()).thenReturn(mUserClicks);
    }

    @Test
    public void onViewCreatedUsersReceived() throws Exception {
        List<User> users = new ArrayList<>();
        TestScheduler scheduler = new TestScheduler();
        TestSubject<List<User>> subject = TestSubject.create(scheduler);
        when(mInteractor.getUserList()).thenReturn(subject);
        mPresenter.attachView(mView);
        verify(mView).showLoading();
        verify(mInteractor).getUserList();
        subject.onNext(users);
        scheduler.triggerActions();
        verify(mView).setUserList(users);
        verify(mView).showContent();
        verify(mView, never()).showError(any());
    }

    @Test
    public void onViewCreatedFailed() throws Exception {
        TestScheduler scheduler = new TestScheduler();
        TestSubject<List<User>> subject = TestSubject.create(scheduler);
        when(mInteractor.getUserList()).thenReturn(subject);
        mPresenter.attachView(mView);
        verify(mView).showLoading();
        verify(mInteractor).getUserList();
        IOException e = new IOException();
        subject.onError(e);
        scheduler.triggerActions();
        verify(mView, never()).setUserList(any());
        verify(mView, never()).showContent();
        verify(mView).showError(e);
    }

    @Test
    public void onItemClicked() throws Exception {
        TestScheduler scheduler = new TestScheduler();
        TestSubject<List<User>> subject = TestSubject.create(scheduler);
        when(mInteractor.getUserList()).thenReturn(subject);
        User user = new User();
        mPresenter.attachView(mView);
        mUserClicks.onNext(user);
        verify(mRouting).startUserDetailsActivity(user);
    }
}