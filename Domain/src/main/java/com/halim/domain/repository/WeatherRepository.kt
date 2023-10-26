package com.halim.domain.repository

import com.halim.domain.models.weather.Weather
import com.halim.domain.models.weather.WeatherDetails
import dagger.Provides
import io.reactivex.rxjava3.core.Observable
import javax.inject.Singleton

interface WeatherRepository {

    fun getWeather():Observable<Weather>

}