package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.base.presenter.ViperPresentersList;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.ListingPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.view.adapter.UserAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public class ListingActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperAiPassiveActivity<ListingContract.View>
        implements ListingContract.View, UserAdapter.UserClickListener {

    public static final String PHOTO_URL_EXTRA_STRING = "PHOTO_URL_EXTRA_STRING";

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.errorView)
    TextView mErrorViewTextView;
    @BindView(R.id.loadingView)
    ProgressBar mLoadingViewProgressBar;

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
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
        mErrorViewTextView.setVisibility(View.VISIBLE);
        mLoadingViewProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
        mErrorViewTextView.setText(throwable.getLocalizedMessage());
    }

    @Override
    public void showLoading() {
        mErrorViewTextView.setVisibility(View.INVISIBLE);
        mLoadingViewProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showContent() {
        mErrorViewTextView.setVisibility(View.INVISIBLE);
        mLoadingViewProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @NonNull
    @Override
    public ViperPresenter<ListingContract.View> createPresenter() {
        return new ViperPresentersList<>(new ListingPresenter());   // you can attach multiple
                                                                    // presenters to
                                                                    // the passive view like this
    }

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
        prepareRecyclerView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_listing;
    }
}
