package com.mateuszkoslacz.moviper.rxsample.viper.interactor;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.rxsample.data.retrofit.GitHubApiInterface;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.SampleServiceContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SampleServiceInteractor
        extends BaseRxInteractor
        implements SampleServiceContract.Interactor {

    private GitHubApiInterface mGitHubApiInterface;

    public SampleServiceInteractor() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(GitHubApiInterface.GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mGitHubApiInterface = mRetrofit.create(GitHubApiInterface.class);
    }

    @Override
    public Observable<User> getUsers() {
        return Observable.create(subscriber -> {
            mGitHubApiInterface.getUsers().subscribe(users -> {
                Observable.interval(2, TimeUnit.SECONDS).take(10)
                        .subscribe(
                                timer -> subscriber.onNext(users.get(timer.intValue())),
                                throwable -> subscriber.onError(throwable),
                                () -> subscriber.onComplete());
            });
        });
    }
}