package com.mateuszkoslacz.sample.viper.interactor;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.sample.retrofit.GitHubApiInterface;
import com.mateuszkoslacz.sample.viper.contract.IndependentContract;
import com.mateuszkoslacz.sample.viper.entity.User;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import io.reactivex.Observable;

public class IndependentInteractor
        extends BaseRxInteractor
        implements IndependentContract.Interactor {

    private GitHubApiInterface gitHubApiInterface;

    public IndependentInteractor() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        gitHubApiInterface = retrofit.create(GitHubApiInterface.class);
    }

    @Override
    public Observable<List<User>> getUserList() {
        return gitHubApiInterface.getUsers();
    }
}
