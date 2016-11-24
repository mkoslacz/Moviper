package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.retrofit.impl;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.impl.AllUsersSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.RetrofitStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public class AllUsersStreamSpecification implements RetrofitStreamSpecification<User> {

    @Override
    public Observable<User> getResults(Retrofit retrofit) {
        return new AllUsersSpecification().getResults(retrofit).flatMap(Observable::from);
    }
}
