package com.mateuszkoslacz.moviper.sample.viewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.data.model.User;
import com.mateuszkoslacz.moviper.sample.viewholder.UserViewHolder;

import java.util.List;

/**
 * Created by jjodelka on 17/10/16.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> userList;
    private Context context;
    private UserClickListener userClickListener;

    public UserAdapter(Context pContext, UserClickListener userClickListener) {
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
        if (userList != null) return userList.size();
        return 0;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public interface UserClickListener {
        void onUserClick(User user);
    }
}
