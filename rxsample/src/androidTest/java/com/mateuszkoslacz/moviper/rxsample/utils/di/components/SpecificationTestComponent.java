package com.mateuszkoslacz.moviper.rxsample.utils.di.components;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.AllUsersSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.di.components.SpecificationComponent;
import com.mateuszkoslacz.moviper.rxsample.utils.di.modules.AllUsersSpecificationTestModule;
import com.mateuszkoslacz.moviper.rxsample.utils.di.modules.UserByUsernameStreamSpecificationTestModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AllUsersSpecificationTestModule.class,
        UserByUsernameStreamSpecificationTestModule.class})
public interface SpecificationTestComponent extends SpecificationComponent {

    UserByUsernameStreamSpecification provideUserByUsernameStreamSpecification();

    AllUsersSpecification provideAllUsersSpecification();
}
