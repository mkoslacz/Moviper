package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductListingItem implements ListingItem {

    private Product mProduct;

    public ProductListingItem(Product product) {
        mProduct = product;
    }

    @Override
    public int getType() {
        return ListingItem.TYPE_PRODUCT;
    }

    public Product getProduct() {
        return mProduct;
    }
}
