package com.example.yajhztask.app.ui.recyclertools.cat

import androidx.recyclerview.widget.DiffUtil
import com.example.yajhztask.domain.models.homecat.DataX

class CatDiffUtil: DiffUtil.ItemCallback<DataX>() {
    override fun areItemsTheSame(oldItem: DataX, newItem: DataX): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataX, newItem: DataX): Boolean {
        return oldItem == newItem
    }
}