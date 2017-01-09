package com.mateuszkoslacz.moviper.rxsample.viper.interactor

import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor
import com.mateuszkoslacz.moviper.rxsample.data.retrofit.GitHubApiInterface
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

class UserDetailsInteractor : BaseRxInteractor(), UserDetailsContract.Interactor {

    private val mGitHubApiInterface: GitHubApiInterface

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        mGitHubApiInterface = retrofit.create(GitHubApiInterface::class.java)
    }

    override fun getUserForUsername(user: String): Observable<User> =
            mGitHubApiInterface.getUserForUsername(user)
}
