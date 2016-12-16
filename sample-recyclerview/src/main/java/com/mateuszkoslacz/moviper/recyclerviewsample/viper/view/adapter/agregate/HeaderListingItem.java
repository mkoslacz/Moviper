package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderListingItem implements ListingItem {

    public static final int TYPE = HeaderListingItem.class.hashCode();
    private Category mCategory;

    public HeaderListingItem(Category category) {
        mCategory = category;
    }

    @Override
    public int getType() {
        return TYPE;
    }

    public Category getCategory() {
        return mCategory;
    }
}
