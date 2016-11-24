package com.mateuszkoslacz.moviper.rxsample.data.rdp.repository;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.base.Specification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.base.StreamSpecification;

import java.util.List;

import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public interface Repository<T> {

    void add(T item);

    void update(T item);

    void remove(T item);

    Observable<T> streamQuery(StreamSpecification specification);

    Observable<List<T>> query(Specification specification);
}
