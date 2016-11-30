package com.mateuszkoslacz.moviper.rxsample.utils.data.rdp.specification.list.test.impl;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.AllUsersSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.List;

import rx.Observable;

public class AllUsersTestSpecification implements AllUsersSpecification {

    public Observable<List<User>> getResults() {
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

        return Observable.just(java.util.Arrays.asList(user1, user2, user3, user4, user5));
    }
}
