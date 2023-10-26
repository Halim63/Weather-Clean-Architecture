package com.halim.remote

import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.repository.weather.WeatherRemote
import com.halim.remote.mapper.weather.WeatherDetailsModelMapper
import com.halim.remote.service.WeatherApiServiceInterface
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import retrofit2.Response
import javax.inject.Inject

const val API_KEY = "92b14692cb6d8a50f3a5923344b94e54"

class WeatherRemoteImpl @Inject constructor(
    private val weatherApiServiceInterface: WeatherApiServiceInterface,
    private val weatherDetailsModelMapper: WeatherDetailsModelMapper,
) : WeatherRemote {
    override fun getWeather(): Observable<Response<WeatherEntityModel>> {
        return weatherApiServiceInterface.getWeather("Egypt", API_KEY)
            .flatMap { list ->

                return@flatMap ObservableSource {
                    if (list.isSuccessful && list.body() != null) {
                         list.body()?.list?.map { model ->
                            weatherDetailsModelMapper.mapFromModel(model)

                        }
                    }

                }
            }
    }
}
