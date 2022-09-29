package com.ds_create.weatherappcource.adapters

import androidx.recyclerview.widget.DiffUtil
import com.ds_create.weatherappcource.models.WeatherModel

class Comparator: DiffUtil.ItemCallback<WeatherModel>() {


    override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
        return oldItem == newItem
    }
}