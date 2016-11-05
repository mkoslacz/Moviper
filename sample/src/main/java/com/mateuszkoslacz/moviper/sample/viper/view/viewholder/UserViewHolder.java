package com.mateuszkoslacz.moviper.sample.viper.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.data.entity.User;
import com.mateuszkoslacz.moviper.sample.viper.view.adapter.UserAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jjodelka on 02/11/16.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.avatar)
    ImageView mAvatarImageView;
    @BindView(R.id.login)
    TextView mLoginTextView;
    @BindView(R.id.url)
    TextView mUrlTextView;
    private View mRowView;

    public UserViewHolder(View itemView) {
        super(itemView);
        this.mRowView = itemView;
        ButterKnife.bind(this, itemView);
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
