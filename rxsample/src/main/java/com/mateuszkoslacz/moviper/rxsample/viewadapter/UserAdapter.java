package com.mateuszkoslacz.moviper.rxsample.viewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.data.model.User;
import com.mateuszkoslacz.moviper.rxsample.viewholder.UserViewHolder;

import java.util.List;

/**
 * Created by jjodelka on 17/10/16.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> mUserList;
    private UserClickListener mUserClickListener;

    public UserAdapter(UserClickListener mUserClickListener) {
        this.mUserClickListener = mUserClickListener;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_row, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(mUserList.get(position), mUserClickListener);
    }

    @Override
    public int getItemCount() {
        return mUserList != null ? mUserList.size() : 0;
    }

    public void setUserList(List<User> userList) {
        this.mUserList = userList;
        notifyDataSetChanged();
    }

    public interface UserClickListener {
        void onUserClick(User user);
    }
}
