package com.mateuszkoslacz.moviper.rxsample.utils.di;

import android.util.Log;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.base.Specification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.base.StreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.List;

import rx.Observable;
import rx.schedulers.TestScheduler;
import rx.subjects.TestSubject;


public class UserTestRepository implements TestRepository<User> {

    private TestScheduler testScheduler;
    private TestSubject<List<User>> testUsersSubject;

    public UserTestRepository() {
        Log.d("UserTestRepository", "constructor");
        this.testScheduler = new TestScheduler();
        this.testUsersSubject = TestSubject.create(testScheduler);
    }

    @Override
    public void add(User item) {

    }

    @Override
    public void update(User item) {

    }

    @Override
    public void remove(User item) {

    }

    @Override
    public Observable<User> streamQuery(StreamSpecification specification) {
        return null;
    }

    @Override
    public Observable<List<User>> query(Specification specification) {
        Log.d("UserTestRepository", "query");
        return testUsersSubject;
    }

    @Override
    public void triggerContentReturn() {
        Log.d("UserTestRepository", "triggerContentReturn");
        User user1 = new User();
        user1.setLogin("user1");
        User user2 = new User();
        user2.setLogin("user2");
        User user3 = new User();
        user3.setLogin("user3");
        User user4 = new User();
        user4.setLogin("user4");
        User user5 = new User();
        user5.setLogin("user5");

        List<User> dummyUsers =  java.util.Arrays.asList(user1, user2, user3, user4, user5);
        testUsersSubject.onNext(dummyUsers);
        testScheduler.triggerActions();
    }

    @Override
    public void triggerError(Exception exception) {
        Log.d("UserTestRepository", "triggerError");
        testUsersSubject.onError(exception);
        testScheduler.triggerActions();
    }
}
