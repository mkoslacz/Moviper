package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.impl;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.RetrofitStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public class UserByUsernameRetrofitStreamSpecification implements RetrofitStreamSpecification<User>, UserByUsernameStreamSpecification {

    private String username;

    @Override
    public Observable<User> getResults(Retrofit retrofit) {
        return retrofit.create(UserByUserNameRetrofitApiCall.class).getUserForUsername(username);
    }

    @Override
    public UserByUsernameStreamSpecification setUserName(String userName) {
        this.username = userName;
        return this;
    }

    private interface UserByUserNameRetrofitApiCall {

        @GET("/users/{username}")
        Observable<User> getUserForUsername(@Path("username") String username);
    }
}
