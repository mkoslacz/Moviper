package com.mateuszkoslacz.moviper.rxsample.viper.interactor

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor
import com.mateuszkoslacz.moviper.rxsample.data.retrofit.GitHubApiInterface
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class ListingInteractor : BaseRxInteractor(), ListingContract.Interactor {

    private val mGitHubApiInterface: GitHubApiInterface

    init {
        val mRetrofit = Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        mGitHubApiInterface = mRetrofit.create(GitHubApiInterface::class.java)
    }

    override val userList: Observable<List<User>>
        get() = mGitHubApiInterface.users
}
