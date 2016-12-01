package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;


import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderItem implements IListingItem {

    private Category mCategory;

    public HeaderItem(Category category) {
        mCategory = category;
    }

    @Override
    public int getType() {
        return IListingItem.TYPE_HEADER;
    }

    public Category getCategory() {
        return mCategory;
    }
}
