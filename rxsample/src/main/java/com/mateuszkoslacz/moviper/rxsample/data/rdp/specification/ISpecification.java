package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */
public interface ISpecification<T> {

    Observable<T> getResults(Retrofit retrofit);
}
