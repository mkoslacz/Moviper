package com.mateuszkoslacz.moviper.sample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseInteractor;
import com.mateuszkoslacz.moviper.sample.data.retrofit.GitHubApiInterface;
import com.mateuszkoslacz.moviper.sample.viper.contract.ListingContract;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListingInteractor
        extends BaseInteractor<ListingContract.PresenterForInteractor>
        implements ListingContract.Interactor {

    private GitHubApiInterface mGitHubApiInterface;

    public ListingInteractor() {
        final Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mGitHubApiInterface = mRetrofit.create(GitHubApiInterface.class);
    }

    @Override
    public void getUserList() {
        if (isPresenterAttached()) {
            Thread thread = new Thread(() -> {
                try {
                    getPresenter().onUserFetched(mGitHubApiInterface
                            .getUsers().execute().body());
                } catch (IOException e) {
                    getPresenter().onUserFetchedError(e);
                }
            });

            thread.start();
        }
    }
}
