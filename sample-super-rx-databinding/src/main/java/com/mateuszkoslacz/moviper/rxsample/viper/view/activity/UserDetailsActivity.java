package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.databinding.ViperDataBindingLcePassiveActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.databinding.ActivityUserDetailsBinding;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.presentersdispatcher.MoviperPresentersDispatcher;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class UserDetailsActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperDataBindingLcePassiveActivity<LinearLayout,
        User,
        UserDetailsContract.View,
        ActivityUserDetailsBinding>
        implements UserDetailsContract.View, UserDetailsContract.ViewHelper {

    public final static String USER_EXTRA = "USER_EXTRA";

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
        mBinding.login.setText(user.getLogin());
        mBinding.url.setText(user.getUrl());
        mBinding.name.setText(user.getName());
        mBinding.company.setText(user.getCompany());
        mBinding.blog.setText(user.getBlog());
        mBinding.location.setText(user.getLocation());
        mBinding.email.setText(user.getEmail());
        Glide.with(this)
                .load(user.getAvatarUrl())
                .into(mBinding.avatar);
        mBinding.avatar.setOnClickListener(v -> mAvatarClicks.onNext(user.getAvatarUrl()));
    }

    @Override
    public Observable<String> getAvatarClicks() {
        return mAvatarClicks;
    }

    @Override
    public View getAvatarImageView() {
        return mBinding.avatar;
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
    public ViperPresenter<UserDetailsContract.View>  createPresenter() {
        return MoviperPresentersDispatcher.getInstance().getPresenterForView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_details;
    }

}
