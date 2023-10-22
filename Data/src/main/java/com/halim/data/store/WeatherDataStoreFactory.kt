package com.halim.data.store

import com.halim.data.repository.weather.WeatherDataStore
import javax.inject.Inject

class WeatherDataStoreFactory (
    private val weatherCacheDataStore: WeatherCacheDataStore,
    private val weatherRemoteDataStore: WeatherRemoteDataStore
) {
    fun getDataStore(
        weatherCached: Boolean,
        cacheExpired: Boolean
    ): WeatherDataStore {
        return if (weatherCached && !cacheExpired) {
            weatherCacheDataStore
        } else {
            weatherRemoteDataStore
        }
    }

    fun getWeatherCacheDataStore(): WeatherDataStore = weatherCacheDataStore

    fun getWeatherRemoteDataStore(): WeatherDataStore = weatherRemoteDataStore


}