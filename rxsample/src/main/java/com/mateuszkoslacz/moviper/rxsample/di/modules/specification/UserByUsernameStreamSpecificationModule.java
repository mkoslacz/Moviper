package com.mateuszkoslacz.moviper.rxsample.di.modules.specification;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.impl.UserByUsernameRetrofitStreamSpecification;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserByUsernameStreamSpecificationModule {

    @Provides
    @Singleton
    UserByUsernameStreamSpecification provideUserByUsernameStreamSpecification() {
        return new UserByUsernameRetrofitStreamSpecification();
    }
}
