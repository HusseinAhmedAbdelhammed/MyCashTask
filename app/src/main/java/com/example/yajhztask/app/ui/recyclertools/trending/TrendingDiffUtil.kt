package com.example.yajhztask.app.ui.recyclertools.trending

import androidx.recyclerview.widget.DiffUtil
import com.example.yajhztask.domain.models.trendingsellers.Data

class TrendingDiffUtil: DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
      return  oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem==newItem
    }
}