package com.mateuszkoslacz.moviper.rxsample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.rxsample.data.model.User;
import com.mateuszkoslacz.moviper.rxsample.data.retrofit.GitHubApiInterface;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ListingInteractor
        extends BaseRxInteractor
        implements ListingContract.Interactor {

    private GitHubApiInterface mGitHubApiInterface;

    public ListingInteractor() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mGitHubApiInterface = mRetrofit.create(GitHubApiInterface.class);
    }

    @Override
    public Observable<List<User>> getUserList() {
        return mGitHubApiInterface.getUsers();
    }
}
