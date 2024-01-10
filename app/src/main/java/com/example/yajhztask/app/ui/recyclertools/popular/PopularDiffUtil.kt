package com.example.yajhztask.app.ui.recyclertools.popular

import androidx.recyclerview.widget.DiffUtil
import com.example.yajhztask.domain.models.popularsellers.Data

class PopularDiffUtil: DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}