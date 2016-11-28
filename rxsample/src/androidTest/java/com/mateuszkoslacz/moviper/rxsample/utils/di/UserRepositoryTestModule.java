package com.mateuszkoslacz.moviper.rxsample.utils.di;


import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.di.modules.repository.UserRepositoryModule;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

public class UserRepositoryTestModule extends UserRepositoryModule {

    @Override
    public Repository<User> provideUserRepository() {
        return new UserTestRepository();
    }
}
