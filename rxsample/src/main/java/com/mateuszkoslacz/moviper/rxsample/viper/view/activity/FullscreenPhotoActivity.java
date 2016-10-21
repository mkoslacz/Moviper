package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.FullscreenPhotoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullscreenPhotoActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends MvpActivity<FullscreenPhotoContract.View, FullscreenPhotoContract.Presenter>
        implements FullscreenPhotoContract.View, FullscreenPhotoContract.ViewHelper {

    @BindView(R.id.photo)
    ImageView mPhotoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_photo);
        ButterKnife.bind(this);

        loadPhoto(getPresenter().getPhotoUrlIntentFromUserDetailsActivity());
    }

    private void loadPhoto(String photoUrlFromIntent) {
        if (!photoUrlFromIntent.equals(""))
            Glide.with(this)
                    .load(photoUrlFromIntent)
                    .into(mPhotoImageView);
    }

    @NonNull
    @Override
    public FullscreenPhotoContract.Presenter createPresenter() {
        return new FullscreenPhotoPresenter(this);
    }
}
