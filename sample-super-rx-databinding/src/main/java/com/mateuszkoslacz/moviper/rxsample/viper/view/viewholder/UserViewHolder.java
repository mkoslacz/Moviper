package com.mateuszkoslacz.moviper.rxsample.viper.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.view.adapter.UserAdapter;

/**
 * Created by jjodelka on 02/11/16.
 */
// TODO probably shall use https://medium.com/google-developers/android-data-binding-recyclerview-db7c40d9f0e4#.h5mv02qjm
public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView mAvatarImageView;
    TextView mLoginTextView;
    TextView mUrlTextView;
    private View mRowView;

    public UserViewHolder(View itemView) {
        super(itemView);
        this.mRowView = itemView;
        mAvatarImageView = (ImageView) itemView.findViewById(R.id.avatar);
        mLoginTextView = (TextView) itemView.findViewById(R.id.login);
        mUrlTextView = (TextView) itemView.findViewById(R.id.url);

    }

    public void bind(User user, UserAdapter.UserClickListener userClickListener) {
        mLoginTextView.setText(user.getLogin());
        mUrlTextView.setText(user.getUrl());
        Glide.with(mRowView.getContext())
                .load(user.getAvatarUrl())
                .into(mAvatarImageView);
        mRowView.setOnClickListener(v -> userClickListener.onUserClick(user));
    }
}
