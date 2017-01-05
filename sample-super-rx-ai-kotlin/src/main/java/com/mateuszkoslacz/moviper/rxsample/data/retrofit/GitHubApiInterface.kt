package com.mateuszkoslacz.moviper.rxsample.data.retrofit

import com.mateuszkoslacz.moviper.rxsample.viper.entity.User

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by jjodelka on 17/10/16.
 */

interface GitHubApiInterface {

    val users: Observable<List<User>>
        @GET("/users")
        get() = users


    @GET("/users/{username}")
    fun getUserForUsername(@Path("username") username: String): Observable<User>

    companion object {

        val GITHUB_API_URL = "https://api.github.com"
    }
}
