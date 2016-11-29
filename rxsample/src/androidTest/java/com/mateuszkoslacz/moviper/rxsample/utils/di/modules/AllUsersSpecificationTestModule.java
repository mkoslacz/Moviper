package com.mateuszkoslacz.moviper.rxsample.utils.di.modules;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.AllUsersSpecification;
import com.mateuszkoslacz.moviper.rxsample.utils.di.AllUsersTestSpecification;

import dagger.Module;
import dagger.Provides;

@Module
public class AllUsersSpecificationTestModule {

    @Provides
    public AllUsersSpecification provideAllUsersSpecification() {
        return new AllUsersTestSpecification();
    }
}
