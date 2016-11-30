package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.base.StreamSpecification;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */
public interface RetrofitStreamSpecification<T> extends StreamSpecification<T> {

    Observable<T> getResults(Retrofit retrofit);

}
