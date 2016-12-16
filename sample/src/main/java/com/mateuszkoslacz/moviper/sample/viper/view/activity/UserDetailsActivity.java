package com.mateuszkoslacz.moviper.sample.viper.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.base.view.activity.ViperLceActivity;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.sample.viper.entity.User;
import com.mateuszkoslacz.moviper.sample.viper.presenter.UserDetailsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperLceActivity
        <LinearLayout,
                User,
                UserDetailsContract.View,
                UserDetailsContract.Presenter>
        implements UserDetailsContract.View, UserDetailsContract.ViewHelper {

    public final static String USER_EXTRA = "USER_EXTRA";

    @BindView(R.id.login)
    TextView mLoginTextView;
    @BindView(R.id.avatar)
    ImageView mAvatarImageView;
    @BindView(R.id.url)
    TextView mUrlTextView;
    @BindView(R.id.name)
    TextView mNameTextView;
    @BindView(R.id.company)
    TextView mCompanyTextView;
    @BindView(R.id.blog)
    TextView mBlogTextView;
    @BindView(R.id.location)
    TextView mLocationTextView;
    @BindView(R.id.email)
    TextView mEmailTextView;

    public static void start(Context context, User user) {
        Intent starter = new Intent(context, UserDetailsActivity.class);
        starter.putExtra(USER_EXTRA, user.getLogin());
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);
        getPresenter().onViewCreated();
    }

    @Override
    public void bindDataToViews(User user) {
        runOnUiThread(() -> {
            mLoginTextView.setText(user.getLogin());
            mUrlTextView.setText(user.getUrl());
            mNameTextView.setText(user.getName());
            mCompanyTextView.setText(user.getCompany());
            mBlogTextView.setText(user.getBlog());
            mLocationTextView.setText(user.getLocation());
            mEmailTextView.setText(user.getEmail());
            Glide.with(this)
                    .load(user.getAvatarUrl())
                    .into(mAvatarImageView);
            mAvatarImageView.setOnClickListener(v ->
                    getPresenter().onAvatarClicked(user.getAvatarUrl()));
        });
    }

    public ImageView getAvatarImageView() {
        return mAvatarImageView;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return e.getLocalizedMessage();
    }

    @Override
    public void setData(User user) {
        bindDataToViews(user);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
    }

    @NonNull
    @Override
    public UserDetailsContract.Presenter createPresenter() {
        return new UserDetailsPresenter(getIntent().getExtras());
    }
}
