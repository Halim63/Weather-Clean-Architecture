package com.halim.remote.service

import com.halim.data.models.weather.WeatherResponseModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiServiceInterface {
     @GET("forecast?")
    fun getWeather(
         @Query("q") city: String,
         @Query("appid") apiKey: String,
    ):Observable<WeatherResponseModel>
}