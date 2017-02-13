package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.butterknife.ViperButterKnifeActivity;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.databinding.ViperDataBindingPassiveActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.databinding.ActivityFullscreenPhotoBinding;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.FullscreenPhotoPresenter;

import butterknife.BindView;

public class FullscreenPhotoActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperDataBindingPassiveActivity<FullscreenPhotoContract.View, ActivityFullscreenPhotoBinding>
        implements FullscreenPhotoContract.View {

    public static final String PHOTO_URL_EXTRA_STRING = "PHOTO_URL_EXTRA_STRING";

    public static void start(Activity activity, String avatarUrl, View avatarView) {
        Intent starter = new Intent(activity, FullscreenPhotoActivity.class);
        starter.putExtra(PHOTO_URL_EXTRA_STRING, avatarUrl);

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity,
                        avatarView,
                        activity.getString(R.string.avatar_transition));
        activity.startActivity(starter, optionsCompat.toBundle());
    }

    @Override
    public void setPhoto(String photoUrl) {
        Glide.with(this)
                .load(photoUrl)
                .into(mBinding.photo);
    }

    @NonNull
    @Override
    public ViperPresenter<FullscreenPhotoContract.View> createPresenter() {
        return new FullscreenPhotoPresenter(getIntent().getExtras());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fullscreen_photo;
    }
}
