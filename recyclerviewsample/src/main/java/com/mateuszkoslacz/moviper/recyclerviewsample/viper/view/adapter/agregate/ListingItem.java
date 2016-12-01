package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;

/**
 * Created by jjodelka on 29/11/2016.
 */

public interface ListingItem {

    int TYPE_HEADER = 0;
    int TYPE_PRODUCT = 1;

    int getType();
}
