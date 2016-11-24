package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.retrofit;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.Specification;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */
public interface RetrofitSpecification<T> extends Specification {

    Observable<List<T>> getResults(Retrofit retrofit);
}
