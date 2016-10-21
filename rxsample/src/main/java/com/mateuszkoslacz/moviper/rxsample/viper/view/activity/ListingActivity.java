package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.data.model.User;
import com.mateuszkoslacz.moviper.rxsample.viewadapter.UserAdapter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.ListingPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends MvpActivity<ListingContract.View, ListingContract.Presenter>
        implements ListingContract.View, UserAdapter.UserClickListener {

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    private List<User> mUserList = new ArrayList<>();
    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        ButterKnife.bind(this);

        prepareRecyclerView();
        getPresenter().onViewCreated();
    }

    @Override
    public void setUserList(List<User> userList) {
        this.mUserList.addAll(userList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onUserClick(User user, UserAdapter.UserViewHolder userViewHolder) {
        getPresenter().onItemClicked(user, userViewHolder);
    }

    private void prepareRecyclerView() {
        mAdapter = new UserAdapter(mUserList, this, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    @NonNull
    @Override
    public ListingContract.Presenter createPresenter() {
        return new ListingPresenter(this);
    }

}
