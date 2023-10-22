package com.halim.remote

import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.repository.weather.WeatherRemote
import com.halim.remote.mapper.weather.WeatherResponseModelMapper
import com.halim.remote.service.WeatherApiServiceInterface
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
const val API_KEY="92b14692cb6d8a50f3a5923344b94e54"

class WeatherRemoteImpl (
    private val weatherApiServiceInterface: WeatherApiServiceInterface,
    private val weatherResponseModelMapper: WeatherResponseModelMapper
):WeatherRemote {
    override fun getWeather(): Observable<WeatherEntityModel> {
        return weatherApiServiceInterface.getWeather("Egypt", API_KEY)
            .map {
                weatherResponseModelMapper.mapFromModel(it)
                }
            }
    }
