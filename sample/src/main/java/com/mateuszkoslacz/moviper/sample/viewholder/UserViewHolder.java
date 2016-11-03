package com.mateuszkoslacz.moviper.sample.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.data.model.User;
import com.mateuszkoslacz.moviper.sample.viewadapter.UserAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jjodelka on 02/11/16.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    View rowView;

    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.url)
    TextView url;

    public UserViewHolder(View itemView) {
        super(itemView);
        this.rowView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Context context, User user, UserAdapter.UserClickListener userClickListener) {
        login.setText(user.getLogin());
        url.setText(user.getUrl());
        Glide.with(context)
                .load(user.getAvatarUrl())
                .into(avatar);
        rowView.setOnClickListener(v -> userClickListener.onUserClick(user));
    }
}
