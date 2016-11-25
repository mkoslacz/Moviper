package com.mateuszkoslacz.moviper.rxsample.utils.di;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.retrofit.impl.AllUsersRetrofitSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

public class AllUsersRetrofitTestSpecification extends AllUsersRetrofitSpecification {

    @Override
    public Observable<List<User>> getResults(Retrofit retrofit) {
        User user1 = new User();
        user1.setName("user1");
        User user2 = new User();
        user2.setName("user2");
        User user3 = new User();
        user3.setName("user3");
        User user4 = new User();
        user4.setName("user4");
        User user5 = new User();
        user5.setName("user5");

        return Observable.just(java.util.Arrays.asList(user1, user2, user3, user4, user5));
    }
}
