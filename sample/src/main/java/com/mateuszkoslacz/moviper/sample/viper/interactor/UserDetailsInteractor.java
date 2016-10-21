package com.mateuszkoslacz.moviper.sample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseInteractor;
import com.mateuszkoslacz.moviper.sample.retrofit.GitHubApiInterface;
import com.mateuszkoslacz.moviper.sample.viper.contract.UserDetailsContract;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserDetailsInteractor
        extends BaseInteractor<UserDetailsContract.PresenterForInteractor>
        implements UserDetailsContract.Interactor {

    private Retrofit mRetrofit;
    private GitHubApiInterface mGitHubApiInterface;

    public UserDetailsInteractor() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GitHubApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mGitHubApiInterface = mRetrofit.create(GitHubApiInterface.class);
    }

    @Override
    public void getUserForUsername(String user) {
        if (isPresenterAttached()) {
            Thread thread = new Thread(() -> {
                try {
                    getPresenter().onUserFetched(mGitHubApiInterface.getUserForUsername(user).execute().body());
                } catch (IOException e) {
                    getPresenter().onUserFetchedError(e);
                }
            });

            thread.start();
        }
    }
}
