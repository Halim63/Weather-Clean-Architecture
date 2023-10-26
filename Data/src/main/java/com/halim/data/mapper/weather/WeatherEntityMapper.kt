package com.halim.data.mapper.weather

import com.halim.data.mapper.EntityMapper
import com.halim.data.models.weather.WeatherEntityModel
import com.halim.domain.models.weather.Weather
import javax.inject.Inject

class WeatherEntityMapper @Inject constructor(
    private val weatherDetailsEntityMapper: WeatherDetailsEntityMapper
) : EntityMapper<WeatherEntityModel, Weather> {


    override fun mapFromEntity(entity: WeatherEntityModel?): Weather {
        return Weather(
            list = entity?.list?.map { weatherDetailsEntity ->
                weatherDetailsEntityMapper.mapFromEntity(weatherDetailsEntity)
            }
        )    }

    override fun mapToEntity(domain: Weather?): WeatherEntityModel {
        return WeatherEntityModel(
            list = domain?.list?.map {weatherDetails ->
            weatherDetailsEntityMapper.mapToEntity(weatherDetails)

            }
        )
    }
}