package com.halim.remote.mapper.weather

import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.models.weather.WeatherResponseModel
import com.halim.remote.mapper.ModelMapper
import javax.inject.Inject

class WeatherResponseModelMapper @Inject constructor (private val weatherDetailsModelMapper: WeatherDetailsModelMapper) :
    ModelMapper<WeatherResponseModel, WeatherEntityModel> {
    override fun mapFromModel(model: WeatherResponseModel?): WeatherEntityModel {
        return WeatherEntityModel(
            list = model?.list?.map { weatherDetailsModel ->
                weatherDetailsModelMapper.mapFromModel(weatherDetailsModel)

            }
        )
    }

}