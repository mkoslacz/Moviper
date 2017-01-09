package com.mateuszkoslacz.moviper.rxsample.viper.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mateuszkoslacz.moviper.rxsample.R
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import com.mateuszkoslacz.moviper.rxsample.viper.view.viewholder.UserViewHolder

/**
 * Created by jjodelka on 17/10/16.
 */

class UserAdapter(private val mUserClickListener: UserAdapter.UserClickListener) :
        RecyclerView.Adapter<UserViewHolder>() {

    private var mUserList: List<User>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_row, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        if (mUserList!= null) holder.bind(mUserList!![position], mUserClickListener)
    }

    override fun getItemCount(): Int = if (mUserList != null) mUserList!!.size else 0


    fun setUserList(userList: List<User>) {
        this.mUserList = userList
        notifyDataSetChanged()
    }

    interface UserClickListener {
        fun onUserClick(user: User)
    }
}
