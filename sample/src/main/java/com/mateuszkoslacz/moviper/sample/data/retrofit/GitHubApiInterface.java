package com.mateuszkoslacz.moviper.sample.data.retrofit;

import com.mateuszkoslacz.moviper.sample.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jjodelka on 17/10/16.
 */

public interface GitHubApiInterface {

    String GITHUB_API_URL = "https://api.github.com";

    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/users/{username}")
    Call<User> getUserForUsername(@Path("username") String username);
}
