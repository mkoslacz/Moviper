package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

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
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import rx.schedulers.TestScheduler;
import rx.subjects.TestSubject;

/**
 * Created by mateuszkoslacz on 17.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListingPresenterTest {

    @Rule
    public final RxAndroidSchedulersOverrideRule mOverrideRule = new RxAndroidSchedulersOverrideRule();

    @Mock
    private ListingInteractor mInteractor;

    @Mock
    private ListingRouting mRouting;

    @Mock
    private ListingActivity mView;

    @InjectMocks
    private ListingPresenter mPresenter = new ListingPresenter(mView);

    @Before
    public void setUpPresenter() {
        mPresenter.attachView(mView);
    }


    @Test
    public void onViewCreated() throws Exception {
        List<User> users = new ArrayList<>();
        TestScheduler scheduler = new TestScheduler();
        TestSubject<List<User>> subject = TestSubject.create(scheduler);
        Mockito.when(mInteractor.getUserList()).thenReturn(subject);
        mPresenter.onViewCreated();
        Mockito.verify(mView).showLoading();
        subject.onNext(users);
        scheduler.triggerActions();
        Mockito.verify(mInteractor).getUserList();
        Mockito.verify(mView).setUserList(users);
        Mockito.verify(mView).showContent();
    }

    @Test
    public void onItemClicked() throws Exception {
        // read more:
        // http://code.hootsuite.com/unit-testing-with-rxandroid-and-rxjava/

        List<User> users = new ArrayList<>();
        TestScheduler scheduler = new TestScheduler();
        TestSubject<List<User>> subject = TestSubject.create(scheduler);
        Mockito.when(mInteractor.getUserList()).thenReturn(subject);
        mInteractor.getUserList()
//                .subscribeOn(scheduler)
//                .observeOn(scheduler)
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
        scheduler.triggerActions();
    }
}