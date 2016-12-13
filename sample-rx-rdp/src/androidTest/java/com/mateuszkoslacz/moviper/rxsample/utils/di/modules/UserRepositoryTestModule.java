package com.mateuszkoslacz.moviper.rxsample.utils.di.modules;


import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.utils.data.rdp.repository.test.UserTestRepository;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserRepositoryTestModule {

    @Provides
    @Singleton
    public Repository<User> provideUserRepository() {
        return new UserTestRepository();
    }
}
