package com.halim.data.mapper.weather

import com.halim.data.mapper.EntityMapper
import com.halim.data.models.weather.WeatherDetailsEntityModel
import com.halim.domain.models.weather.WeatherDetails
import javax.inject.Inject

class WeatherDetailsEntityMapper @Inject constructor(
    private val mainEntityMapper: MainEntityMapper
):EntityMapper<WeatherDetailsEntityModel,WeatherDetails> {

    override fun mapFromEntity(entity: WeatherDetailsEntityModel?): WeatherDetails {
        return WeatherDetails(
            dtTxt = entity?.dtTxt,
            main = mainEntityMapper.mapFromEntity(entity?.mainEntity)

        )    }

    override fun mapToEntity(domain: WeatherDetails?): WeatherDetailsEntityModel {
return WeatherDetailsEntityModel(
    dtTxt = domain?.dtTxt,
    mainEntity = mainEntityMapper.mapToEntity(domain?.main)

)   }
}