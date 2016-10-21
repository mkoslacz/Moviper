package com.mateuszkoslacz.moviper.rxsample.data.retrofit;

import com.mateuszkoslacz.moviper.rxsample.data.model.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jjodelka on 17/10/16.
 */

public interface GitHubApiInterface {
    String GitHubApiUrl = "https://api.github.com";

    @GET("/users")
    Observable<List<User>> getUsers();

    @GET("/users/{username}")
    Observable<User> getUserForUsername(@Path("username") String username);
}
