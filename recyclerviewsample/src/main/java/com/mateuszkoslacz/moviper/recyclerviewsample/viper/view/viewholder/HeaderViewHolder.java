package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder;

import android.view.View;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.base.view.MvpViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.HeaderContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.HeaderPresenterMoviper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderViewHolder extends
        MvpViewHolder<HeaderContract.View, HeaderContract.Presenter>
        implements HeaderContract.View, HeaderContract.ViewHelper {

    @BindView(R.id.product_title)
    TextView mProductTitleTextView;

    private String title;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindPresenter() {
        super.bindPresenter();
        getPresenter().requestFillingView();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setTitleToTextView(String title) {
        mProductTitleTextView.setText(title);
    }

    @Override
    public HeaderContract.Presenter createPresenter() {
        return new HeaderPresenterMoviper(itemView);
    }
}
