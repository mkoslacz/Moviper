package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;


/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderItem implements IListingItem {

    private String mTitle;

    public HeaderItem(String title) {
        mTitle = title;
    }

    @Override
    public int getType() {
        return IListingItem.TYPE_HEADER;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }
}
