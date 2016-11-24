package com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.retrofit;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.IRepository;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.ISpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public class UserRetrofitRepository implements IRepository<User> {

    public static final String GITHUB_API_URL = "https://api.github.com";

    private Retrofit retrofit;

    public UserRetrofitRepository() {
        retrofit = new Retrofit.Builder()
                .baseUrl(GITHUB_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Override
    public void add(User item) {
        throw new RuntimeException("UserRetrofitRepository: DB not implemented yet.");
    }

    @Override
    public void update(User item) {
        throw new RuntimeException("UserRetrofitRepository: DB not implemented yet.");
    }

    @Override
    public void remove(User item) {
        throw new RuntimeException("UserRetrofitRepository: DB not implemented yet.");
    }

    @Override
    public Observable<User> query(ISpecification specification) {
        return specification.getResults(retrofit);
    }
}
