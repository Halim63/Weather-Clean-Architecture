package com.halim.cache.mapper.weather

import com.halim.cache.mapper.CacheMapper
import com.halim.cache.models.weather.WeatherCacheModel
import com.halim.data.models.weather.MainEntityModel
import com.halim.data.models.weather.WeatherDetailsEntityModel
import javax.inject.Inject

class WeatherCacheMapper @Inject constructor(
) : CacheMapper<WeatherCacheModel, WeatherDetailsEntityModel> {
    override fun mapFromCached(model: WeatherCacheModel?): WeatherDetailsEntityModel {
        return WeatherDetailsEntityModel(
            dtTxt = model?.date,
            mainEntity = MainEntityModel(model?.temperature)
        )
    }

    override fun mapToCached(entity: WeatherDetailsEntityModel?): WeatherCacheModel {
        return WeatherCacheModel(
            temperature = entity?.mainEntity?.temp,
            date = entity?.dtTxt

        )
    }


}