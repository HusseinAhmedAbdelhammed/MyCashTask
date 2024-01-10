package com.example.yajhztask.app.ui.recyclertools.popular

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.yajhztask.R
import com.example.yajhztask.databinding.PopularNowBinding
import com.example.yajhztask.domain.models.popularsellers.Data

class PopularAdapter(var context: Context?): ListAdapter<Data, PopularViewHolder>(PopularDiffUtil()) {
    lateinit var binding: PopularNowBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding= PopularNowBinding.inflate(inflater,parent,false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val currentItem=getItem(position)
        Glide.with(context!!).load(currentItem.image).into(holder.binding.backImage)
        holder.binding.distance.text=currentItem.distance
        holder.binding.rating.text=currentItem.rate
        holder.binding.ratingBar.rating=currentItem.rate.toFloat()
        holder.binding.item.text=currentItem.name
        holder.binding.favBtn.setOnClickListener(object:OnClickListener{
            override fun onClick(p0: View?) {
                holder.binding.favBtn.setImageResource(R.drawable.lovecolored)
            }

        })
    }
}