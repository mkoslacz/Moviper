package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductListingItem implements ListingItem {

    public static final int TYPE = ProductListingItem.class.hashCode();
    private Product mProduct;

    public ProductListingItem(Product product) {
        mProduct = product;
    }

    @Override
    public int getType() {
        return TYPE;
    }

    public Product getProduct() {
        return mProduct;
    }
}
