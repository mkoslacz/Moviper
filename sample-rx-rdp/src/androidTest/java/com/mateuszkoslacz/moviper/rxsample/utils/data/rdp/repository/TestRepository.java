package com.mateuszkoslacz.moviper.rxsample.utils.data.rdp.repository;


import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;

public interface TestRepository<T> extends Repository<T> {

    void triggerContentReturn();

    void triggerError(Exception exception);
}
