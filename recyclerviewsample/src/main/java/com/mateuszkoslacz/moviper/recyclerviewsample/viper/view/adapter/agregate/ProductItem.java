package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate;


import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductItem implements IListingItem {

    private Product mProduct;

    public ProductItem(Product product) {
        mProduct = product;
    }

    @Override
    public int getType() {
        return IListingItem.TYPE_PRODUCT;
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
    }
}
