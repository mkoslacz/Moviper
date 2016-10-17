package com.mateuszkoslacz.moviper.rxsample.data.retrofit;

import com.mateuszkoslacz.moviper.rxsample.data.model.User;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jjodelka on 17/10/16.
 */

public interface GitHubApiInterface {
    @GET("/users")
    Observable<User> getUser();

    @GET("/users/{username}")
    Observable<User> getUser(@Path("username") String username);
}
