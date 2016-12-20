package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.base.view.ViperViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.HeaderContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.HeaderPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderViewHolder
        extends ViperViewHolder<Category, HeaderContract.View, HeaderContract.Presenter>
        implements HeaderContract.View {

    @BindView(R.id.product_title)
    TextView mProductTitleTextView;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setTitle(String title) {
        mProductTitleTextView.setText(title);
    }

    @Override
    @NonNull
    public HeaderContract.Presenter createPresenter() {
        return new HeaderPresenter();
    }
}
