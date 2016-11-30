package com.mateuszkoslacz.moviper.rxsample.utils.data.rdp.specification.stream.test.impl;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import rx.Observable;

/**
 * Created by bwilk on 11/29/16.
 */

public class UserByUsernameStreamTestSpecification implements UserByUsernameStreamSpecification {

    private String username;

    public Observable<User> getResults() {
        User user = new User();
        user.setName(username);
        return Observable.just(user);
    }

    @Override
    public UserByUsernameStreamSpecification setUserName(String userName) {
        this.username = userName;
        return this;
    }
}
