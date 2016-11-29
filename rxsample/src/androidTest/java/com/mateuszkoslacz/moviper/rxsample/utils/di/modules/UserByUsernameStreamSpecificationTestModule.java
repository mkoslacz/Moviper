package com.mateuszkoslacz.moviper.rxsample.utils.di.modules;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.utils.di.UserByUsernameStreamTestSpecification;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bwilk on 11/29/16.
 */

@Module
public class UserByUsernameStreamSpecificationTestModule {

    @Provides
    public UserByUsernameStreamSpecification provideUserByUsernameStreamSpecification() {
        return new UserByUsernameStreamTestSpecification();
    }
}
