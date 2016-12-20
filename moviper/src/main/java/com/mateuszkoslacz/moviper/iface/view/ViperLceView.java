package com.mateuszkoslacz.moviper.iface.view;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

/**
 * Created by tomasznajda on 14.12.2016.
 * </p>
 * The root view interface for every VIPER LCE view.
 * It shall not be used in Contract.
 */

public interface ViperLceView<Model> extends MvpLceView<Model>, ViperView {

}
