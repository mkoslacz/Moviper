package com.mateuszkoslacz.moviper.rxsample.viper.interactor

import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor
import com.mateuszkoslacz.moviper.rxsample.data.retrofit.GitHubApiInterface
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

open class ListingInteractor : BaseRxInteractor(), ListingContract.Interactor {

    private val mGitHubApiInterface: GitHubApiInterface

    init {
        val mRetrofit = Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        mGitHubApiInterface = mRetrofit.create(GitHubApiInterface::class.java)
    }

    override val userList: Observable<List<User>>
        get() = mGitHubApiInterface.users
}
