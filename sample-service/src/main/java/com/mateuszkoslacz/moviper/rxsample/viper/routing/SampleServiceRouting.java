package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Service;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.SampleServiceContract;

public class SampleServiceRouting
        extends BaseRxRouting<Service>
        implements SampleServiceContract.Routing {

}
