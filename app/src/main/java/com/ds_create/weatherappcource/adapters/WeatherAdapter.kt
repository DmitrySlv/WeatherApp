package com.ds_create.weatherappcource.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ds_create.weatherappcource.R
import com.ds_create.weatherappcource.databinding.ListItemBinding
import com.ds_create.weatherappcource.models.WeatherModel
import com.squareup.picasso.Picasso

class WeatherAdapter(val listener: Listener?): ListAdapter<WeatherModel, WeatherAdapter.ViewHolder>(Comparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.setData(getItem(position))
    }

    class ViewHolder(view: View, val listener: Listener?): RecyclerView.ViewHolder(view) {
       private val binding = ListItemBinding.bind(view)
        var itemTemp: WeatherModel? = null

        init {
            itemView.setOnClickListener {
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }

        fun setData(item: WeatherModel) = with(binding) {
            itemTemp = item
            tvDate.text = item.time
            tvCondition.text = item.condition
            tvTemp.text = item.currentTemp.ifEmpty { "${item.maxTemp}°C / ${item.minTemp}" }
            Picasso.get().load("https:" + item.imageUrl).into(imageView)
        }
    }

    interface Listener {
        fun onClick(item: WeatherModel)
    }
}