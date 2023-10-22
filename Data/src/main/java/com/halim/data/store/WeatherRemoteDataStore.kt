package com.halim.data.store

import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.repository.weather.WeatherDataStore
import com.halim.data.repository.weather.WeatherRemote
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import javax.inject.Inject

class WeatherRemoteDataStore (private val weatherRemote: WeatherRemote)
    :WeatherDataStore {
    override fun getWeather(): Observable<WeatherEntityModel> {
        return weatherRemote.getWeather()
    }

    override fun clearWeather(): Completable {
        TODO("Not yet implemented")
    }

    override fun saveWeather(weatherEntity: WeatherEntityModel): Completable {
        TODO("Not yet implemented")
    }
}