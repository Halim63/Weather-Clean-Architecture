package com.halim.data.repository.weather

import com.halim.data.models.weather.WeatherEntityModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

interface WeatherRemote {
    fun getWeather(): Observable<WeatherEntityModel>

}