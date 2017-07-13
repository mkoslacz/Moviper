package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.ListingActivity;
import com.mateuszkoslacz.moviper.tests.rules.RxAndroidSchedulersOverrideRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    TestScheduler scheduler = new TestScheduler();
    PublishSubject<List<User>> mGetUserListSubject = PublishSubject.create();

    @Before
    public void setUpPresenter() {
        //detach presenter
        mPresenter.detachView(false);

        //mock observables used in attach method
        when(mInteractor.getUserList()).thenReturn(mGetUserListSubject);

        //attach view
        mPresenter.attachView(mView);
    }

    @Test
    public void onViewCreatedUsersReceived() throws Exception {
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler1 -> scheduler);
        RxJavaPlugins.setIoSchedulerHandler(scheduler1 -> scheduler);
        RxJavaPlugins.setComputationSchedulerHandler(scheduler1 -> scheduler);
        List<User> users = new ArrayList<>();
        verify(mView).showLoading();
        verify(mInteractor).getUserList();
        mGetUserListSubject.onNext(users);
        scheduler.triggerActions();
        verify(mView).setUserList(users);
        verify(mView).showContent();
        verify(mView, never()).showError(any());
    }

    @Test
    public void onViewCreatedFailed() throws Exception {
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler1 -> scheduler);
        RxJavaPlugins.setIoSchedulerHandler(scheduler1 -> scheduler);
        RxJavaPlugins.setComputationSchedulerHandler(scheduler1 -> scheduler);
        verify(mView).showLoading();
        verify(mInteractor).getUserList();
        IOException e = new IOException();
        mGetUserListSubject.onError(e);
        scheduler.triggerActions();
        verify(mView, never()).setUserList(any());
        verify(mView, never()).showContent();
        verify(mView).showError(e);
    }

    @Test
    public void onItemClicked() throws Exception {
        User user = new User();
        mPresenter.onItemClicked(user);
        verify(mRouting).startUserDetailsActivity(user);
    }
}