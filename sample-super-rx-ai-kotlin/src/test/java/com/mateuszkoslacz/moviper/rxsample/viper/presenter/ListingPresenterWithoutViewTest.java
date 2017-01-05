package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.ListingActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.TestScheduler;
import rx.subjects.PublishSubject;
import rx.subjects.TestSubject;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mateuszkoslacz on 17.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListingPresenterWithoutViewTest extends ListingPresenterTest {

    @Test
    public void onViewCreatedUsersReceived() throws Exception {
        List<User> users = new ArrayList<>();
        TestScheduler scheduler = new TestScheduler();
        TestSubject<List<User>> subject = TestSubject.create(scheduler);
        when(mInteractor.getUserList()).thenReturn(subject);
        ListingActivity mock = Mockito.mock(ListingActivity.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                if (invocation.getMethod().getReturnType().equals(Observable.class))
                    return PublishSubject.create();
                else return null;
            }
        });
        mPresenter.attachView(mock);
        mPresenter.detachView(false);
        verify(mInteractor).getUserList();
        subject.onNext(users);
        scheduler.triggerActions();
        verify(mView, never()).setUserList(users);
        verify(mView, never()).showContent();
        verify(mView, never()).showError(any(Throwable.class));
    }

    @Test
    public void onViewCreatedFailed() throws Exception {
        TestScheduler scheduler = new TestScheduler();
        TestSubject<List<User>> subject = TestSubject.create(scheduler);
        when(mInteractor.getUserList()).thenReturn(subject);
        ListingActivity mock = Mockito.mock(ListingActivity.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                if (invocation.getMethod().getReturnType().equals(Observable.class))
                    return PublishSubject.create();
                else return null;
            }
        });
        mPresenter.attachView(mock);
        mPresenter.detachView(false);
        verify(mInteractor).getUserList();
        IOException e = new IOException();
        subject.onError(e);
        scheduler.triggerActions();
        verify(mView, never()).setUserList(any(List.class));
        verify(mView, never()).showContent();
        verify(mView, never()).showError(e);
    }

}