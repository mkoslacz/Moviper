package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.base.view.ViperViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.ProductContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.ProductPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductViewHolder
        extends ViperViewHolder<Product, ProductContract.View, ProductContract.Presenter>
        implements ProductContract.View {

    @BindView(R.id.product_photo)
    ImageView mProductPhoto;
    @BindView(R.id.product_title)
    TextView mProductTitle;
    @BindView(R.id.product_price)
    TextView mProductPrice;
    @BindView(R.id.product_description)
    TextView mProductDescription;

    public ProductViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setTitle(String productTitle) {
        mProductTitle.setText(productTitle);
    }

    public void setDescription(String productDescription) {
        mProductDescription.setText(productDescription);
    }

    public void setPhoto(String productPhotoUrl) {
        Glide.with(itemView.getContext())
                .load(productPhotoUrl)
                .into(mProductPhoto);
    }

    public void setPrice(String productPrice) {
        mProductPrice.setText(productPrice);
    }

    @Override
    @NonNull
    public ProductContract.Presenter createPresenter() {
        return new ProductPresenter();
    }

}
