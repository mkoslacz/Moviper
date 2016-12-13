package com.mateuszkoslacz.moviper.rxsample.utils.di.components;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.di.components.RepositoryComponent;
import com.mateuszkoslacz.moviper.rxsample.utils.di.modules.UserRepositoryTestModule;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UserRepositoryTestModule.class})
public interface RepositoryTestComponent extends RepositoryComponent {

    Repository<User> provideUserRepository();
}
