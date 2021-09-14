package com.example.recyclerview.multipleViewType

data class ItemViewHolder<T>(
    val itemData: T,
    val type: Int
)
