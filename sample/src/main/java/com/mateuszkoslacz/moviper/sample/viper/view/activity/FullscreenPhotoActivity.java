package com.mateuszkoslacz.moviper.sample.viper.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.base.view.activity.ViperActivity;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.FullscreenPhotoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullscreenPhotoActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperActivity<FullscreenPhotoContract.View, FullscreenPhotoContract.Presenter>
        implements FullscreenPhotoContract.View {

    public static final String PHOTO_URL_EXTRA_STRING = "PHOTO_URL_EXTRA_STRING";

    @BindView(R.id.photo)
    ImageView mPhotoImageView;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_photo);
        ButterKnife.bind(this);
        getPresenter().onViewCreated();
    }

    @Override
    public void setPhoto(String photoUrl) {
        Glide.with(this)
                .load(photoUrl)
                .into(mPhotoImageView);
    }

    @NonNull
    @Override
    public FullscreenPhotoContract.Presenter createPresenter() {
        return new FullscreenPhotoPresenter(getIntent().getExtras());
    }
}