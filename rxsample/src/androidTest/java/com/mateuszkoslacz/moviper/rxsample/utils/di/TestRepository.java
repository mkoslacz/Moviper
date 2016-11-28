package com.mateuszkoslacz.moviper.rxsample.utils.di;


import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;

public interface TestRepository<User> extends Repository<User>{

    void triggerContentReturn();
    void triggerError(Exception exception);
}
