package com.mateuszkoslacz.moviper.rxsample.di.modules.specification;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.AllUsersSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.list.retrofit.impl.AllUsersRetrofitSpecification;

import dagger.Module;
import dagger.Provides;

@Module
public class AllUsersSpecificationModule {

    @Provides
    public AllUsersSpecification provideAllUsersSpecification() {
        return new AllUsersRetrofitSpecification();
    }
}
