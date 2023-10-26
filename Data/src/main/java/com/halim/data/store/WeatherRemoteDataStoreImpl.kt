package com.halim.data.store

import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.repository.weather.WeatherDataStore
import com.halim.data.repository.weather.WeatherRemote
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import javax.inject.Inject

class WeatherRemoteDataStoreImpl @Inject constructor(private val weatherRemote: WeatherRemote)
    : WeatherDataStore {
    override fun getWeather(): Observable<WeatherEntityModel>{
        return weatherRemote.getWeather()
    }


}