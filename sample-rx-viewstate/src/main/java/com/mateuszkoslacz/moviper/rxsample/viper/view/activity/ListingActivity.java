package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

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

import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.ViperViewStateActivity;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.view.adapter.UserAdapter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.ListingPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.view.viewstate.ListingViewState;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperViewStateActivity
        <ListingContract.View,
                ListingContract.Presenter,
                ListingViewState>
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
        setRetainInstance(true);
        ButterKnife.bind(this);
        prepareRecyclerView();
    }

    @Override
    public void setUserList(List<User> userList, boolean retained) {
        mAdapter.setUserList(userList);
        if (!retained) getViewState().setUserList(userList);
    }

    private void prepareRecyclerView() {
        mAdapter = new UserAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onUserClick(User user) {
        getPresenter().onItemClicked(user);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter = null;
    }

    @Override
    public void showError(Throwable throwable) {
        mErrorViewTextView.setVisibility(View.VISIBLE);
        mLoadingViewProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
        mErrorViewTextView.setText(throwable.getLocalizedMessage());
        getViewState().setError(throwable);
    }

    @Override
    public void showLoading() {
        mErrorViewTextView.setVisibility(View.INVISIBLE);
        mLoadingViewProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
        getViewState().setState(ListingViewState.STATE_LOADING);
    }

    @Override
    public void showContent() {
        mErrorViewTextView.setVisibility(View.INVISIBLE);
        mLoadingViewProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
        getViewState().setState(ListingViewState.STATE_CONTENT);
    }

    @NonNull
    @Override
    public ListingContract.Presenter createPresenter() {
        return new ListingPresenter();
    }

    @NonNull
    @Override
    public ViewState<ListingContract.View> createViewState() {
        return new ListingViewState();
    }

    @Override
    public void onNewViewStateInstance() {
        getPresenter().onViewCreated();
    }
}
