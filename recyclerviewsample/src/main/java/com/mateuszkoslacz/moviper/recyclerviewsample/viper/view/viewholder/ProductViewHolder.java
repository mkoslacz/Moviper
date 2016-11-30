package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.base.view.MvpViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.ProductContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.ProductPresenterMoviper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductViewHolder
        extends MvpViewHolder<ProductContract.View, ProductContract.Presenter>
        implements ProductContract.View, ProductContract.ViewHelper {

    @BindView(R.id.product_photo)
    ImageView mProductPhoto;
    @BindView(R.id.product_title)
    TextView mProductTitle;
    @BindView(R.id.product_price)
    TextView mProductPrice;
    @BindView(R.id.product_description)
    TextView mProductDescription;

    Product mProduct;

    public ProductViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public Product getProduct() {
        return mProduct;
    }

    @Override
    public void setProduct(Product product) {
        mProduct = product;
    }

    public void setProductTitle(String productTitle) {
        mProductTitle.setText(productTitle);
    }

    public void setProductDescription(String productDescription) {
        mProductDescription.setText(productDescription);
    }

    public void setProductPhoto(String productPhotoUrl) {
        Glide.with(itemView.getContext())
                .load(productPhotoUrl)
                .into(mProductPhoto);
    }

    public void setProductPrice(String productPrice) {
        mProductPrice.setText(productPrice);
    }

    @Override
    public ProductContract.Presenter createPresenter() {
        return new ProductPresenterMoviper(itemView);
    }

}
