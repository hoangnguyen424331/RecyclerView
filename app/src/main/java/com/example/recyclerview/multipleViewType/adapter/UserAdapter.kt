package com.example.recyclerview.multipleViewType.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.multipleViewType.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val context: Context) : RecyclerView.Adapter<UserAdapter.UserItemViewHolder>() {

    private var listUser = mutableListOf<User>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.UserItemViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserItemViewHolder, position: Int) {
        holder.bindData(listUser[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListUser: MutableList<User>) {
        listUser = newListUser
        notifyDataSetChanged()
    }

    override fun getItemCount() = listUser.size

    inner class UserItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(user: User) {
            itemView.imageViewAvatar.background = context.getDrawable(user.avatar)
            itemView.textViewName.text = user.name
        }
    }
}
