package com.mateuszkoslacz.moviper.rxsample.di.modules.specification;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.AllUsersSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.retrofit.impl.AllUsersRetrofitSpecification;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bwilk on 11/24/16.
 */

@Module
public class AllUsersSpecificationModule {

    @Provides
    @Singleton
    public AllUsersSpecification provideAllUsersSpecification() {
        return new AllUsersRetrofitSpecification();
    }

}
