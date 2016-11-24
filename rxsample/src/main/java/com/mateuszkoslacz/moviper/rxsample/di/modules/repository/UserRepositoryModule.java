package com.mateuszkoslacz.moviper.rxsample.di.modules.repository;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.retrofit.UserRetrofitRepository;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bwilk on 11/24/16.
 */

@Module
public class UserRepositoryModule {

    @Provides
    @Singleton
    Repository<User> provideUserRepository() {
        return new UserRetrofitRepository();
    }

}
