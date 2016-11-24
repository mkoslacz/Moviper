package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.retrofit;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.ISpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public class AllUsersSpecification implements ISpecification<User> {

    @Override
    public Observable<User> getResults(Retrofit retrofit) {
        return retrofit.create(AllUsersSpecificationRetrofitApiCall.class)
                .getUsers().flatMap(Observable::from);
    }

    private interface AllUsersSpecificationRetrofitApiCall {

        @GET("/users")
        Observable<List<User>> getUsers();
    }
}
