package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.retrofit;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.ISpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public class UserByUsernameSpecification implements ISpecification<User> {

    private String username;

    public UserByUsernameSpecification(String username) {
        this.username = username;
    }

    @Override
    public Observable<User> getResults(Retrofit retrofit) {
        return retrofit.create(UserByUserNameRetrofitApiCall.class).getUserForUsername(username);
    }

    private interface UserByUserNameRetrofitApiCall {

        @GET("/users/{username}")
        Observable<User> getUserForUsername(@Path("username") String username);
    }
}