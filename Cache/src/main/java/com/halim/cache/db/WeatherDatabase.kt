package com.halim.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.halim.cache.models.weather.WeatherCacheModel

@Database(entities = [WeatherCacheModel::class], version = 1)

abstract class WeatherDatabase :RoomDatabase(){

    abstract fun getDBWeather():WeatherDao
}