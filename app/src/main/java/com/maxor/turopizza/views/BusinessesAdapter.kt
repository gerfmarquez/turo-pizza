package com.maxor.turopizza.views

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.maxor.turopizza.R
import com.maxor.turopizza.data.TuroBusinessData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rl_business_row.view.*
import java.text.DecimalFormat

class BusinessesAdapter : ListAdapter<TuroBusinessData, BusinessesAdapter.Holder>(
    diffCallback = object : DiffUtil.ItemCallback<TuroBusinessData>() {
        override fun areItemsTheSame(oldItem: TuroBusinessData, newItem: TuroBusinessData): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: TuroBusinessData, newItem: TuroBusinessData): Boolean {
            return oldItem.id == newItem.id
        }
    }) {

    class Holder(val rowLayout: RelativeLayout) : RecyclerView.ViewHolder(rowLayout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val searchResultLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.rl_business_row, parent, false) as RelativeLayout
        return Holder(searchResultLayout)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.rowLayout.tv_business_name.text = getItem(position).name
        holder.rowLayout.tv_business_rating.text = getItem(position).rating.toString()
        val formatDistance = DecimalFormat().format(getItem(position).distance)
        holder.rowLayout.tv_distance.text = "Distance: $formatDistance"
        Picasso.get().load(getItem(position).image_url).into(holder.rowLayout.iv_business_thumbnail)
    }

}