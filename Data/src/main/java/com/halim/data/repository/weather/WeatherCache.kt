package com.halim.data.repository.weather

import com.halim.data.models.weather.WeatherEntityModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface WeatherCache {
    fun getWeather(): Observable<WeatherEntityModel>
    fun clearWeather():Completable
    fun saveWeather(weatherEntity: WeatherEntityModel):Completable
    fun areWeatherCached():Single<Boolean>
    fun isWeatherCachedExpired():Single<Boolean>

}