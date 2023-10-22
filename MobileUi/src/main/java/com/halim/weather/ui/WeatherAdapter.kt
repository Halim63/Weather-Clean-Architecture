package com.halim.weather.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.halim.presentation.models.weather.WeatherDetailsPresentationModel
import com.halim.presentation.models.weather.WeatherPresentationModel
import com.halim.weather.databinding.ListItemBinding

class WeatherAdapter:
RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> (){
    private val items = ArrayList<WeatherDetailsPresentationModel>()


    class WeatherViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflator, parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

        val weather=items[position]
      holder.binding.temprture.text =weather.mainEntity?.temp.toString()
        holder.binding.date.text=weather.dtTxt
           }



    override fun getItemCount() =items.size



    }







