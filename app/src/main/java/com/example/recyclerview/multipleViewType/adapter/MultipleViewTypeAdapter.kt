package com.example.recyclerview.multipleViewType.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.multipleViewType.Const.TYPE_HEADER
import com.example.recyclerview.multipleViewType.Const.TYPE_ITEM
import com.example.recyclerview.multipleViewType.ItemViewHolder
import com.example.recyclerview.multipleViewType.model.FooterInfo
import com.example.recyclerview.multipleViewType.model.HeaderInfo
import com.example.recyclerview.multipleViewType.model.UserInfo
import kotlinx.android.synthetic.main.item_footer_info.view.*
import kotlinx.android.synthetic.main.item_header_info.view.*
import kotlinx.android.synthetic.main.item_user_info.view.*

class MultipleViewTypeAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listItemViewHolder = mutableListOf<ItemViewHolder<Any>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_header_info, parent, false)
                HeaderInfoViewHolder(view)
            }
            TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user_info, parent, false)
                UserInfoViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_footer_info, parent, false)
                FooterInfoViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderInfoViewHolder -> {
                val item = listItemViewHolder[position] as ItemViewHolder<HeaderInfo>
                holder.bindData(item)
            }
            is UserInfoViewHolder -> {
                val item = listItemViewHolder[position] as ItemViewHolder<UserInfo>
                holder.bindData(item)
            }
            is FooterInfoViewHolder -> {
                val item = listItemViewHolder[position] as ItemViewHolder<FooterInfo>
                holder.bindData(item)
            }
        }
    }

    override fun getItemCount() = listItemViewHolder.size

    override fun getItemViewType(position: Int) = listItemViewHolder[position].type

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: MutableList<ItemViewHolder<Any>>) {
        listItemViewHolder = list
        notifyDataSetChanged()
    }

    inner class HeaderInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(itemViewHolder: ItemViewHolder<HeaderInfo>) {
            val listHeaderInfo = mutableListOf(
                itemViewHolder.itemData.info1,
                itemViewHolder.itemData.info2,
                itemViewHolder.itemData.info3
            )
            val headerAdapter = HeaderAdapter()
            headerAdapter.setData(listHeaderInfo)
            itemView.recyclerViewHeader.adapter = headerAdapter
        }
    }

    inner class UserInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(itemViewHolder: ItemViewHolder<UserInfo>) {
            val listUserInfo = mutableListOf(
                itemViewHolder.itemData.user1,
                itemViewHolder.itemData.user2,
                itemViewHolder.itemData.user3
            )
            val userAdapter = UserAdapter(context)
            userAdapter.setData(listUserInfo)
            itemView.recyclerViewUser.adapter = userAdapter
        }
    }

    inner class FooterInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(itemViewHolder: ItemViewHolder<FooterInfo>) {
            val listFooterInfo = mutableListOf(
                itemViewHolder.itemData.info1,
                itemViewHolder.itemData.info2,
                itemViewHolder.itemData.info3
            )
            val footerAdapter = FooterAdapter()
            footerAdapter.setData(listFooterInfo)
            itemView.recyclerViewFooter.adapter = footerAdapter
        }
    }
}
