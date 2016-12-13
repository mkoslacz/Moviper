package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderListingItem implements ListingItem {

    private Category mCategory;

    public HeaderListingItem(Category category) {
        mCategory = category;
    }

    @Override
    public int getType() {
        return ListingItem.TYPE_HEADER;
    }

    public Category getCategory() {
        return mCategory;
    }
}
