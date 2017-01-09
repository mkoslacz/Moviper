package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperLceAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.presentersdispatcher.MoviperPresentersDispatcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public class UserDetailsActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperLceAiPassiveActivity
        <LinearLayout,
                User,
                UserDetailsContract.View>
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

    PublishSubject<String> mAvatarClicks = PublishSubject.create();

    public static void start(Context context, User user) {
        context.startActivity(getStartingIntent(context, user));
    }

    public static Intent getStartingIntent(Context context, User user) {
        Intent starter = new Intent(context, UserDetailsActivity.class);
        starter.putExtra(USER_EXTRA, user.getLogin());
        return starter;
    }

    @Override
    public void bindDataToViews(User user) {
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
        mAvatarImageView.setOnClickListener(v -> mAvatarClicks.onNext(user.getAvatarUrl()));
    }

    @Override
    public Subject<String, String> getAvatarClicks() {
        return mAvatarClicks;
    }

    @Override
    public View getAvatarImageView() {
        return mAvatarImageView;
    }

    @Override
    public void setData(User user) {
        bindDataToViews(user);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return e.getLocalizedMessage();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
    }

    @NonNull
    @Override
    public ViperPresenter<UserDetailsContract.View> createPresenter() {
        return MoviperPresentersDispatcher.getInstance().getPresenterForView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_details;
    }

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
