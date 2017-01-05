package com.mateuszkoslacz.moviper.rxsample.viper.view.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User
import com.mateuszkoslacz.moviper.rxsample.viper.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.item_user_row.view.*

/**
 * Created by jjodelka on 02/11/16.
 */

class UserViewHolder(private val mRowView: View) : RecyclerView.ViewHolder(mRowView) {

    fun bind(user: User, userClickListener: UserAdapter.UserClickListener) {
        itemView.login.text = user.login
        itemView.url.text = user.url
        Glide.with(mRowView.context)
                .load(user.avatarUrl)
                .into(itemView.avatar)
        mRowView.setOnClickListener { userClickListener.onUserClick(user) }
    }
}
