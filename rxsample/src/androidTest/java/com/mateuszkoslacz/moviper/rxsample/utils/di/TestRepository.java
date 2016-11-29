package com.mateuszkoslacz.moviper.rxsample.utils.di;


import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;

public interface TestRepository<T> extends Repository<T> {

    void triggerContentReturn();

    void triggerError(Exception exception);
}
