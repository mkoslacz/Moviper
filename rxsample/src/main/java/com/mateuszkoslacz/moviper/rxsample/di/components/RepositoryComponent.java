package com.mateuszkoslacz.moviper.rxsample.di.components;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.di.modules.repository.UserRepositoryModule;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UserRepositoryModule.class})
public interface RepositoryComponent {

    Repository<User> provideUserRepository();
}
