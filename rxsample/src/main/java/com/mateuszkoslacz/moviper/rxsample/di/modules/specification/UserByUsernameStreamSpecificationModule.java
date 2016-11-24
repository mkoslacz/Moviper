package com.mateuszkoslacz.moviper.rxsample.di.modules.specification;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.impl.UserByUsernameRetrofitStreamSpecification;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bwilk on 11/24/16.
 */

@Module
public class UserByUsernameStreamSpecificationModule {

    @Provides
    @Singleton
    public UserByUsernameStreamSpecification provideUserByUsernameStreamSpecification() {
        return new UserByUsernameRetrofitStreamSpecification();
    }

}
