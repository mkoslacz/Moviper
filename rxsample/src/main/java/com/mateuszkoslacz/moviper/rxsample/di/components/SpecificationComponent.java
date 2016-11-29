package com.mateuszkoslacz.moviper.rxsample.di.components;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.AllUsersSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.di.modules.specification.AllUsersSpecificationModule;
import com.mateuszkoslacz.moviper.rxsample.di.modules.specification.UserByUsernameStreamSpecificationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UserByUsernameStreamSpecificationModule.class, AllUsersSpecificationModule.class})
public interface SpecificationComponent {

    UserByUsernameStreamSpecification provideUserByUsernameStreamSpecification();

    AllUsersSpecification provideAllUsersSpecification();
}
