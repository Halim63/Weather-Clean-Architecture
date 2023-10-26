package com.halim.domain.usecases

import com.halim.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUsecase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) {
    fun getWeather() =weatherRepository.getWeather()

}