package com.halim.data.store

import com.halim.data.repository.weather.WeatherDataStore
import javax.inject.Inject

class WeatherDataStoreFactory @Inject constructor(
    private val weatherCacheDataStoreImpl: WeatherCacheDataStoreImpl,
    private val weatherRemoteDataStoreImpl: WeatherRemoteDataStoreImpl
) {
    fun getDataStore(
        weatherCached: Boolean,
        cacheExpired: Boolean
    ): WeatherDataStore {
        return if (weatherCached && !cacheExpired) {
            weatherCacheDataStoreImpl
        } else {
            weatherRemoteDataStoreImpl
        }
    }
    fun getWeatherCacheDataStore(): WeatherDataStore = weatherCacheDataStoreImpl



}