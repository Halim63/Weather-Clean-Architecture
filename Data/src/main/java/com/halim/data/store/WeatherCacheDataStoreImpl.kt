package com.halim.data.store

import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.repository.weather.WeatherCache
import com.halim.data.repository.weather.WeatherDataStore
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class WeatherCacheDataStoreImpl @Inject constructor(private val weatherCache: WeatherCache) :
    WeatherDataStore {
    override fun getWeather(): Observable<WeatherEntityModel> {
        return weatherCache.getWeather()
    }


}