package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.utils.RxAndroidSchedulersOverrideRule;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.ListingActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.schedulers.TestScheduler;
import rx.subjects.TestSubject;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    TestScheduler mGetUserListScheduler = new TestScheduler();
    TestSubject<List<User>> mGetUserListSubject = TestSubject.create(mGetUserListScheduler);
    TestScheduler mGetUserClicksScheduler = new TestScheduler();
    TestSubject<User> mGetUserClicksSubject = TestSubject.create(mGetUserClicksScheduler);

    @Before
    public void setUpPresenter() {
        //detach presenter
        mPresenter.detachView(false);

        //mock observables used in attach method
        when(mInteractor.getUserList()).thenReturn(mGetUserListSubject);
        when(mView.getUserClicks()).thenReturn(mGetUserClicksSubject);

        //attach view
        mPresenter.attachView(mView);
    }

    @Test
    public void onViewCreatedUsersReceived() throws Exception {
        List<User> users = new ArrayList<>();
        verify(mView).showLoading();
        verify(mInteractor).getUserList();
        mGetUserListSubject.onNext(users);
        mGetUserListScheduler.triggerActions();
        verify(mView).setUserList(users);
        verify(mView).showContent();
        verify(mView, never()).showError(any());
    }

    @Test
    public void onViewCreatedFailed() throws Exception {
        verify(mView).showLoading();
        verify(mInteractor).getUserList();
        IOException e = new IOException();
        mGetUserListSubject.onError(e);
        mGetUserListScheduler.triggerActions();
        verify(mView, never()).setUserList(any());
        verify(mView, never()).showContent();
        verify(mView).showError(e);
    }

    @Test
    public void onItemClicked() throws Exception {
        User user = new User();
        mGetUserClicksSubject.onNext(user);
        mGetUserClicksScheduler.triggerActions();
        verify(mRouting).startUserDetailsActivity(user);
    }
}