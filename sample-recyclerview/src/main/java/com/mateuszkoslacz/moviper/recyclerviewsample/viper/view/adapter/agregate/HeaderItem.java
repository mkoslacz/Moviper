package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderItem implements DisplayableItem {

    public static final int TYPE = HeaderItem.class.hashCode();
    private Category mCategory;

    public HeaderItem(Category category) {
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
