package com.halim.domain.repository

import com.halim.domain.models.weather.Weather
import dagger.Provides
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

interface WeatherRepository {

    fun getWeather():Observable<Weather>

}