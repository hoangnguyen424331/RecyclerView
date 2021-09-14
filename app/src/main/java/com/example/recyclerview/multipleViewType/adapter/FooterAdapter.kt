package com.example.recyclerview.multipleViewType.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_footer.view.*

class FooterAdapter : RecyclerView.Adapter<FooterAdapter.FooterItemViewHolder>() {

    private var listInfo = mutableListOf<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FooterAdapter.FooterItemViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.item_footer, parent, false)
        return FooterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FooterAdapter.FooterItemViewHolder, position: Int) {
        holder.bindData(listInfo[position])
    }

    override fun getItemCount() = listInfo.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListInfo: MutableList<String>) {
        listInfo = newListInfo
        notifyDataSetChanged()
    }

    inner class FooterItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(info: String) {
            itemView.textViewFooter.text = info
        }
    }
}
