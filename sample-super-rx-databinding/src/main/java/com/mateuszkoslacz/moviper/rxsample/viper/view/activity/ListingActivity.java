package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.databinding.ViperDataBindingPassiveActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.databinding.ActivityListingBinding;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.ListingPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.view.adapter.UserAdapter;

import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;

public class ListingActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperDataBindingPassiveActivity<ListingContract.View, ActivityListingBinding>
        implements ListingContract.View, UserAdapter.UserClickListener {

    public static final String PHOTO_URL_EXTRA_STRING = "PHOTO_URL_EXTRA_STRING";

    PublishSubject<User> mUserClicks = PublishSubject.create();

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
    public Observable<User> getUserClicks() {
        return mUserClicks;
    }

    @Override
    public void setUserList(List<User> userList) {
        mAdapter.setUserList(userList);
    }

    private void prepareRecyclerView() {
        mAdapter = new UserAdapter(this);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        mBinding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onUserClick(User user) {
        mUserClicks.onNext(user);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter = null;
    }

    @Override
    public void showError(Throwable throwable) {
        mBinding.errorView.setVisibility(View.VISIBLE);
        mBinding.loadingView.setVisibility(View.INVISIBLE);
        mBinding.recyclerView.setVisibility(View.INVISIBLE);
        mBinding.errorView.setText(throwable.getLocalizedMessage());
    }

    @Override
    public void showLoading() {
        mBinding.errorView.setVisibility(View.INVISIBLE);
        mBinding.loadingView.setVisibility(View.VISIBLE);
        mBinding.recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showContent() {
        mBinding.errorView.setVisibility(View.INVISIBLE);
        mBinding.loadingView.setVisibility(View.INVISIBLE);
        mBinding.recyclerView.setVisibility(View.VISIBLE);
    }

    @NonNull
    @Override
    public ViperPresenter<ListingContract.View, ?, ?> createPresenter() {
        return new ListingPresenter();
    }

    @Override
    protected void injectViews() {
        super.injectViews();
        prepareRecyclerView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_listing;
    }
}
