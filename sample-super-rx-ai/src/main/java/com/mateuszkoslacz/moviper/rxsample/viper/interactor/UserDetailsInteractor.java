package com.mateuszkoslacz.moviper.rxsample.viper.interactor;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.data.retrofit.GitHubApiInterface;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import io.reactivex.Observable;

public class UserDetailsInteractor
        extends BaseRxInteractor
        implements UserDetailsContract.Interactor {

    private GitHubApiInterface mGitHubApiInterface;

    public UserDetailsInteractor() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mGitHubApiInterface = retrofit.create(GitHubApiInterface.class);
    }

    @Override
    public Observable<User> getUserForUsername(String user) {
        return mGitHubApiInterface.getUserForUsername(user);
    }
}
