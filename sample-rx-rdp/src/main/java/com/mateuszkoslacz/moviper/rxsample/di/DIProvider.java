package com.mateuszkoslacz.moviper.rxsample.di;


import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.mateuszkoslacz.moviper.rxsample.di.components.DaggerRepositoryComponent;
import com.mateuszkoslacz.moviper.rxsample.di.components.DaggerSpecificationComponent;
import com.mateuszkoslacz.moviper.rxsample.di.components.RepositoryComponent;
import com.mateuszkoslacz.moviper.rxsample.di.components.SpecificationComponent;
import com.mateuszkoslacz.moviper.rxsample.di.modules.repository.UserRepositoryModule;
import com.mateuszkoslacz.moviper.rxsample.di.modules.specification.AllUsersSpecificationModule;
import com.mateuszkoslacz.moviper.rxsample.di.modules.specification.UserByUsernameStreamSpecificationModule;

public class DIProvider {

    private static DIProvider instance;
    private RepositoryComponent repositoryComponent;
    private SpecificationComponent specificationComponent;
    private Context context;

    private DIProvider() {

    }

    public static DIProvider getInstance() {
        if (instance == null) {
            instance = new DIProvider();
        }
        return instance;
    }

    public RepositoryComponent getRepositoryComponent() {
        assertNonNullContext();
        if (repositoryComponent == null) {
            repositoryComponent = DaggerRepositoryComponent.builder()
                    .userRepositoryModule(new UserRepositoryModule())
                    .build();
        }
        return repositoryComponent;
    }

    public SpecificationComponent getSpecificationComponent() {
        assertNonNullContext();
        if (specificationComponent == null) {
            specificationComponent = DaggerSpecificationComponent.builder()
                    .allUsersSpecificationModule(new AllUsersSpecificationModule())
                    .userByUsernameStreamSpecificationModule(new UserByUsernameStreamSpecificationModule())
                    .build();
        }
        return specificationComponent;
    }

    public void init(Context context) {
        this.context = context;
    }

    @VisibleForTesting
    public void setRepositoryComponent(RepositoryComponent component) {
        repositoryComponent = component;
    }

    @VisibleForTesting
    public void setSpecificationComponent(SpecificationComponent component) {
        specificationComponent = component;
    }

    private void assertNonNullContext() {
        if (context == null) {
            throw new IllegalStateException("You have to init DIProvider with context first");
        }
    }
}
