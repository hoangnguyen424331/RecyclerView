package com.example.recyclerview.multipleViewType.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_header.view.*

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderItemViewHolder>() {

    private var listHeader = mutableListOf<String>()

    fun setData(newListHeader: MutableList<String>) {
        listHeader = newListHeader
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderItemViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_header,parent,false)
        return HeaderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderItemViewHolder, position: Int) {
        holder.bindData(listHeader[position])
    }

    override fun getItemCount() = listHeader.size

    inner class HeaderItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindData(header: String) {
            itemView.textViewHeader.text = header
        }
    }
}
