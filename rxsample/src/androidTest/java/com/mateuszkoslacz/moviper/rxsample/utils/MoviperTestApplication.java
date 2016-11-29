package com.mateuszkoslacz.moviper.rxsample.utils;

import com.mateuszkoslacz.moviper.rxsample.MoviperApplication;
import com.mateuszkoslacz.moviper.rxsample.di.DIProvider;
import com.mateuszkoslacz.moviper.rxsample.di.components.RepositoryComponent;
import com.mateuszkoslacz.moviper.rxsample.di.components.SpecificationComponent;
import com.mateuszkoslacz.moviper.rxsample.utils.di.components.DaggerRepositoryTestComponent;
import com.mateuszkoslacz.moviper.rxsample.utils.di.components.DaggerSpecificationTestComponent;
import com.mateuszkoslacz.moviper.rxsample.utils.di.modules.AllUsersSpecificationTestModule;
import com.mateuszkoslacz.moviper.rxsample.utils.di.modules.UserByUsernameStreamSpecificationTestModule;
import com.mateuszkoslacz.moviper.rxsample.utils.di.modules.UserRepositoryTestModule;


public class MoviperTestApplication extends MoviperApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        DIProvider.init(this);
        SpecificationComponent specificationComponent = DaggerSpecificationTestComponent.builder()
                .allUsersSpecificationTestModule(new AllUsersSpecificationTestModule())
                .userByUsernameStreamSpecificationTestModule(new UserByUsernameStreamSpecificationTestModule())
                .build();

        RepositoryComponent repositoryComponent = DaggerRepositoryTestComponent.builder()
                .userRepositoryTestModule(new UserRepositoryTestModule())
                .build();

        DIProvider.setSpecificationComponent(specificationComponent);
        DIProvider.setRepositoryComponent(repositoryComponent);
    }
}
