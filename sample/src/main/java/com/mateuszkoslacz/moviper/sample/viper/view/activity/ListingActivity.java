package com.mateuszkoslacz.moviper.sample.viper.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.data.model.User;
import com.mateuszkoslacz.moviper.sample.viewadapter.UserAdapter;
import com.mateuszkoslacz.moviper.sample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.ListingPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends MvpActivity<ListingContract.View, ListingContract.Presenter>
        implements ListingContract.View, UserAdapter.UserClickListener {

    public static final String PHOTO_URL_EXTRA_STRING = "PHOTO_URL_EXTRA_STRING";

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.errorView)
    TextView mErrorViewTextView;
    @BindView(R.id.loadingView)
    ProgressBar mLoadingViewProgressBar;

    private UserAdapter mAdapter;

    public static void start(Activity activity, String avatarUrl, ImageView avatarImageView) {
        Intent starter = new Intent(activity, FullscreenPhotoActivity.class);
        starter.putExtra(PHOTO_URL_EXTRA_STRING, avatarUrl);

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity,
                        avatarImageView,
                        activity.getString(R.string.avatar_transition));
        activity.startActivity(starter, optionsCompat.toBundle());
    }

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
        runOnUiThread(() -> {
            mAdapter.setmUserList(userList);
            mAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onUserClick(User user) {
        getPresenter().onItemClicked(user);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter = null;
    }

    private void prepareRecyclerView() {
        mAdapter = new UserAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showError(Throwable throwable) {
        runOnUiThread(() -> {
            mErrorViewTextView.setVisibility(View.VISIBLE);
            mLoadingViewProgressBar.setVisibility(View.INVISIBLE);
            mRecyclerView.setVisibility(View.INVISIBLE);
            mErrorViewTextView.setText(throwable.getLocalizedMessage());
        });
    }

    @Override
    public void showLoading() {
        runOnUiThread(() -> {
            mErrorViewTextView.setVisibility(View.INVISIBLE);
            mLoadingViewProgressBar.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.INVISIBLE);
        });
    }

    @Override
    public void showContent() {
        runOnUiThread(() -> {
            mErrorViewTextView.setVisibility(View.INVISIBLE);
            mLoadingViewProgressBar.setVisibility(View.INVISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);
        });
    }

    @NonNull
    @Override
    public ListingContract.Presenter createPresenter() {
        return new ListingPresenter(this);
    }

}
