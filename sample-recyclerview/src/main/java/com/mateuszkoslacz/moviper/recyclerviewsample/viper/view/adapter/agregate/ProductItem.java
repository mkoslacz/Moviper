package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductItem implements DisplayableItem {

    public static final int TYPE = ProductItem.class.hashCode();
    private Product mProduct;

    public ProductItem(Product product) {
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
