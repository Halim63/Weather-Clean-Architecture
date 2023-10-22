package com.halim.domain.usecases

import com.halim.domain.executor.ObservableUseCase
import com.halim.domain.executor.PostExecutionThread
import com.halim.domain.models.weather.Weather
import com.halim.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetWeatherUsecase @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val postExecutionThread: PostExecutionThread
) :ObservableUseCase<Weather,GetWeatherUsecase.Params>(postExecutionThread){


    data class Params(val weatherId:String) {
        companion object {
            fun forWeather(weatherId:String) :Params{
                return Params(weatherId)
            }
        }
    }

    override fun buildUseCaseObservable(params: Params?): Observable<Weather> {
        if (params==null)   throw IllegalAccessException("Params can't be null")
        return weatherRepository.getWeather()

    }
}