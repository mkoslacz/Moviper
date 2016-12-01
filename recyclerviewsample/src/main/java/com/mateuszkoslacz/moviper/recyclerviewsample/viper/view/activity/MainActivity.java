package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.MainPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.ProductAdapter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.IListingItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity
        extends MvpActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View, MainContract.ViewHelper {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setRecyclerView();

        getPresenter().onViewCreated();
    }

    @Override
    public void setListingItems(List<IListingItem> listingItems) {
        mProductAdapter.setListingItems(listingItems);
    }

    private void setRecyclerView() {
        mProductAdapter = new ProductAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mProductAdapter);
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

}
