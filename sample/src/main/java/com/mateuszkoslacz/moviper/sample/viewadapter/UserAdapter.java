package com.mateuszkoslacz.moviper.sample.viewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.model.User;

import java.util.List;

/**
 * Created by jjodelka on 17/10/16.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;
    private Context context;
    private UserClickListener userClickListener;

    public UserAdapter(List<User> pUserList, Context pContext, UserClickListener userClickListener) {
        this.userList = pUserList;
        this.context = pContext;
        this.userClickListener = userClickListener;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_row, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(context, userList.get(position), userClickListener);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        View rowView;

        ImageView avatar;
        TextView login;
        TextView url;

        public UserViewHolder(View itemView) {
            super(itemView);
            this.rowView = itemView;
            this.avatar = (ImageView) itemView.findViewById(R.id.avatar);
            this.login = (TextView) itemView.findViewById(R.id.login);
            this.url = (TextView) itemView.findViewById(R.id.url);
        }

        protected void bind(Context context, User user, UserClickListener userClickListener) {
            login.setText(user.getLogin());
            url.setText(user.getUrl());
            Glide.with(context)
                    .load(user.getAvatarUrl())
                    .into(avatar);
            rowView.setOnClickListener(v -> userClickListener.onUserClick(user, this));
        }
    }

    public interface UserClickListener {
        void onUserClick(User user, UserViewHolder userViewHolder);
    }
}
