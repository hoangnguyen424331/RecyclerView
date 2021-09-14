package com.example.recyclerview.dragDrop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_drag_drog.view.*

class ItemAdapter : ListAdapter<Item, ItemAdapter.ItemDragViewHolder>(ItemDiffUntil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDragViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_drag_drog,parent,false)
        return ItemDragViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemDragViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class ItemDiffUntil : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    inner class ItemDragViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: Item) {
            itemView.textViewItem.text = item.nameItem
        }
    }
}
