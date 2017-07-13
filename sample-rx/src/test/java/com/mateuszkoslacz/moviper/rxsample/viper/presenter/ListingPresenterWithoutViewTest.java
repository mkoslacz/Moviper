package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.TestScheduler;
import io.reactivex.subjects.PublishSubject;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mateuszkoslacz on 17.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListingPresenterWithoutViewTest extends ListingPresenterTest {

    @Before
    public void setUpPresenter() {
        mPresenter.detachView(false);
    }

    TestScheduler scheduler = new TestScheduler();

    public ListingPresenterWithoutViewTest(){
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler1 -> scheduler);
        RxJavaPlugins.setIoSchedulerHandler(scheduler1 -> scheduler);
        RxJavaPlugins.setComputationSchedulerHandler(scheduler1 -> scheduler);
    }

    @Test
    public void onViewCreatedUsersReceived() throws Exception {
        List<User> users = new ArrayList<>();
        PublishSubject<List<User>> subject = PublishSubject.create();
        when(mInteractor.getUserList()).thenReturn(subject);
        mPresenter.onViewCreated();
        verify(mView, never()).showLoading();
        verify(mInteractor).getUserList();
        subject.onNext(users);
        scheduler.triggerActions();
        verify(mView, never()).setUserList(users);
        verify(mView, never()).showContent();
        verify(mView, never()).showError(any());
    }

    @Test
    public void onViewCreatedFailed() throws Exception {
        PublishSubject<List<User>> subject = PublishSubject.create();
        when(mInteractor.getUserList()).thenReturn(subject);
        mPresenter.onViewCreated();
        verify(mView, never()).showLoading();
        verify(mInteractor).getUserList();
        IOException e = new IOException();
        subject.onError(e);
        scheduler.triggerActions();
        verify(mView, never()).setUserList(any());
        verify(mView, never()).showContent();
        verify(mView, never()).showError(e);
    }

}