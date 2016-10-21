package com.mateuszkoslacz.moviper.rxsample.viper.interactor;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.rxsample.data.model.User;
import com.mateuszkoslacz.moviper.rxsample.data.retrofit.GitHubApiInterface;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class UserDetailsInteractor
        extends BaseRxInteractor
        implements UserDetailsContract.Interactor {

    private Retrofit mRetrofit;
    private GitHubApiInterface mGitHubApiInterface;

    public UserDetailsInteractor() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GitHubApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mGitHubApiInterface = mRetrofit.create(GitHubApiInterface.class);
    }

    @RxLogObservable(RxLogObservable.Scope.STREAM)
    @Override
    public Observable<User> getUserForUsername(String user) {
        return mGitHubApiInterface.getUserForUsername(user);
    }
}
