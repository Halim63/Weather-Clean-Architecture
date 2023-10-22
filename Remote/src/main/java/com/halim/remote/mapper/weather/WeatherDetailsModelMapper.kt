package com.halim.remote.mapper.weather

import com.halim.data.models.weather.WeatherDetailsEntityModel
import com.halim.data.models.weather.WeatherDetailsModel
import com.halim.remote.mapper.ModelMapper
import javax.inject.Inject

class WeatherDetailsModelMapper @Inject constructor(private val mainModelMapper: MainModelMapper) :
    ModelMapper<WeatherDetailsModel, WeatherDetailsEntityModel> {
    override fun mapFromModel(model: WeatherDetailsModel?): WeatherDetailsEntityModel {
        return WeatherDetailsEntityModel(
            dtTxt = model?.dtTxt,
            mainEntity = mainModelMapper.mapFromModel(model?.mainEntity)

        )
    }
}