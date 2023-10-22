package com.halim.data.store

import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.repository.weather.WeatherCache
import com.halim.data.repository.weather.WeatherDataStore
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class WeatherCacheDataStore (private val weatherCache: WeatherCache) :WeatherDataStore{
    override fun getWeather(): Observable<WeatherEntityModel> {
        return weatherCache.getWeather()
    }

    override fun clearWeather(): Completable {
        TODO("Not yet implemented")
    }

    override fun saveWeather(weatherEntity: WeatherEntityModel): Completable {
        TODO("Not yet implemented")
    }
}