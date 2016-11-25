package com.mateuszkoslacz.moviper.rxsample.utils;

import com.mateuszkoslacz.moviper.rxsample.Moviper;
import com.mateuszkoslacz.moviper.rxsample.di.DIProvider;
import com.mateuszkoslacz.moviper.rxsample.di.components.DaggerSpecificationComponent;
import com.mateuszkoslacz.moviper.rxsample.di.components.SpecificationComponent;
import com.mateuszkoslacz.moviper.rxsample.di.modules.specification.UserByUsernameStreamSpecificationModule;
import com.mateuszkoslacz.moviper.rxsample.utils.di.AllUsersSpecificationTestModule;


public class MoviperTestApplication extends Moviper {

    @Override
    public void onCreate() {
        super.onCreate();

        DIProvider.init(this);
        SpecificationComponent specificationTestComponent = DaggerSpecificationComponent.builder()
                .allUsersSpecificationModule(new AllUsersSpecificationTestModule())
                .userByUsernameStreamSpecificationModule(new UserByUsernameStreamSpecificationModule())
                .build();

        DIProvider.setSpecificationComponent(specificationTestComponent);
    }
}
