package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.impl;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.retrofit.RetrofitSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public class AllUsersSpecification implements RetrofitSpecification<User> {

    @Override
    public Observable<List<User>> getResults(Retrofit retrofit) {
        return retrofit.create(AllUsersSpecificationRetrofitApiCall.class).getUsers();
    }

    private interface AllUsersSpecificationRetrofitApiCall {

        @GET("/users")
        Observable<List<User>> getUsers();
    }
}
