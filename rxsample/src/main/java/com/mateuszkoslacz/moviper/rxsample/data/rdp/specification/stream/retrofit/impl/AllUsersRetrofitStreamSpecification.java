package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.impl;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.retrofit.impl.AllUsersRetrofitSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.AllUsersStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.RetrofitStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public class AllUsersRetrofitStreamSpecification implements RetrofitStreamSpecification<User>, AllUsersStreamSpecification {

    @Override
    public Observable<User> getResults(Retrofit retrofit) {
        return new AllUsersRetrofitSpecification().getResults(retrofit).flatMap(Observable::from);
    }
}
