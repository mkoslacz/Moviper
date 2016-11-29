package com.mateuszkoslacz.moviper.rxsample.di.modules.repository;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.retrofit.UserRetrofitRepository;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import dagger.Module;
import dagger.Provides;

@Module
public class UserRepositoryModule {

    @Provides
    public Repository<User> provideUserRepository() {
        return new UserRetrofitRepository();
    }
}
