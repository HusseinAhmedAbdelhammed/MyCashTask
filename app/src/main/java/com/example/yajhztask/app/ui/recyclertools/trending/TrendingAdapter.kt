package com.example.yajhztask.app.ui.recyclertools.trending

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.yajhztask.app.ui.recyclertools.popular.PopularDiffUtil
import com.example.yajhztask.app.ui.recyclertools.popular.PopularViewHolder
import com.example.yajhztask.databinding.PopularNowBinding
import com.example.yajhztask.databinding.TrendingRowBinding
import com.example.yajhztask.domain.models.trendingsellers.Data

class TrendingAdapter(var context: Context?): ListAdapter<Data, TrendingViewHolder>(TrendingDiffUtil()) {
    lateinit var binding: TrendingRowBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding= TrendingRowBinding.inflate(inflater,parent,false)
        return TrendingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val currentItem=getItem(position)
        Glide.with(context!!).load(currentItem.image).into(holder.binding.image)
    }
}