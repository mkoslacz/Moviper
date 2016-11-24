package com.mateuszkoslacz.moviper.rxsample.data.rdp.repository;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.ISpecification;

import rx.Observable;

/**
 * Created by jjodelka on 23/11/2016.
 */

public interface IRepository<T> {

    void add(T item);

    void update(T item);

    void remove(T item);

    Observable<T> query(ISpecification specification);
}
