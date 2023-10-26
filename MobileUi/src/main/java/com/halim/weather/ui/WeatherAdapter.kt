package com.halim.weather.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.halim.presentation.models.weather.WeatherDetailsPresentationModel
import com.halim.weather.databinding.ListItemBinding

class WeatherAdapter :
    ListAdapter<WeatherDetailsPresentationModel, WeatherAdapter.WeatherViewHolder>(UserDiffUtil()) {
    private lateinit var binding: ListItemBinding

    class WeatherViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        binding = ListItemBinding.inflate(inflator, parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = currentList[position]
        holder.binding.tvTemprture.text = weather.mainEntity?.temp.toString()
        holder.binding.tvDate.text = weather.dtTxt.toString()
    }

}

class UserDiffUtil : DiffUtil.ItemCallback<WeatherDetailsPresentationModel>() {
    override fun areItemsTheSame(
        oldItem: WeatherDetailsPresentationModel,
        newItem: WeatherDetailsPresentationModel,
    ): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(
        oldItem: WeatherDetailsPresentationModel,
        newItem: WeatherDetailsPresentationModel,
    ): Boolean {
        return oldItem.id == newItem.id
    }
}
