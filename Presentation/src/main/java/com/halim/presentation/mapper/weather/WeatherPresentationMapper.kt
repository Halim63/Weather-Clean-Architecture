package com.halim.presentation.mapper.weather

import com.halim.domain.models.weather.Weather
import com.halim.presentation.mapper.PresentationMapper
import com.halim.presentation.models.weather.WeatherPresentationModel
import javax.inject.Inject

class WeatherPresentationMapper @Inject constructor(
    private val weatherDetailsPresentationMapper: WeatherDetailsPresentationMapper
):PresentationMapper<WeatherPresentationModel,Weather> {
    override fun mapToView(type: Weather?): WeatherPresentationModel {
        return WeatherPresentationModel(
            list = type?.list?.map {weatherDetails ->
            weatherDetailsPresentationMapper.mapToView(weatherDetails)

            }
        )
    }
}