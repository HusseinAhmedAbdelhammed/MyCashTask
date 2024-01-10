package com.example.yajhztask.app.ui.recyclertools.cat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.yajhztask.databinding.CatRowBinding
import com.example.yajhztask.domain.models.homecat.DataX

class CatAdapter(var context: Context?): ListAdapter<DataX, CatViewHolder>(CatDiffUtil()) {
    lateinit var binding: CatRowBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding= CatRowBinding.inflate(inflater,parent,false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val currentItem=getItem(position)
        Glide.with(context!!).load(currentItem.image).into(holder.binding.imageView)
    }
}