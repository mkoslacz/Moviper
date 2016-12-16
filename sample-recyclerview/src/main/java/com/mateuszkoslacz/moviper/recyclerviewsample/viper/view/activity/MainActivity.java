package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mateuszkoslacz.moviper.base.view.activity.ViperActivity;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.MainPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.ProductAdapter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ListingItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity
        extends ViperActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configureRecyclerView();

        getPresenter().onViewCreated();
    }

    @Override
    public void setData(List<ListingItem> listingItems) {
        mProductAdapter.setListingItems(listingItems);
    }

    private void configureRecyclerView() {
        mProductAdapter = new ProductAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mProductAdapter);
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }
}
