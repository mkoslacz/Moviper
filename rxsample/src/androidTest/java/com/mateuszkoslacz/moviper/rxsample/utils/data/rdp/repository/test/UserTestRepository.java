package com.mateuszkoslacz.moviper.rxsample.utils.data.rdp.repository.test;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.base.Specification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.base.StreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.utils.data.rdp.specification.list.test.impl.AllUsersTestSpecification;
import com.mateuszkoslacz.moviper.rxsample.utils.data.rdp.repository.TestRepository;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.List;

import rx.Observable;
import rx.schedulers.TestScheduler;
import rx.subjects.TestSubject;


public class UserTestRepository implements TestRepository<User> {

    private TestScheduler testScheduler;
    private TestSubject<List<User>> testUsersSubject;

    public UserTestRepository() {
        this.testScheduler = new TestScheduler();
        this.testUsersSubject = TestSubject.create(testScheduler);
    }

    @Override
    public void add(User item) {
        throw new RuntimeException("This method is not allowed in test repository");
    }

    @Override
    public void update(User item) {
        throw new RuntimeException("This method is not allowed in test repository");

    }

    @Override
    public void remove(User item) {
        throw new RuntimeException("This method is not allowed in test repository");
    }

    @Override
    public Observable<User> streamQuery(StreamSpecification specification) {
        throw new RuntimeException("This method is not allowed in test repository");
    }

    @Override
    public Observable<List<User>> query(Specification specification) {
        ((AllUsersTestSpecification) specification).getResults()
                .subscribe(testUsersSubject::onNext, testUsersSubject::onError);
        return testUsersSubject;
    }

    @Override
    public void triggerContentReturn() {
        testScheduler.triggerActions();
    }

    @Override
    public void triggerError(Exception exception) {
        testUsersSubject.onError(exception);
        testScheduler.triggerActions();
    }
}
