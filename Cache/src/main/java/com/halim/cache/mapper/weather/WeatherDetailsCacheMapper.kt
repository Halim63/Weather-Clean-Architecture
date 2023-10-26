package com.halim.cache.mapper.weather

import com.halim.cache.mapper.CacheMapper
import com.halim.cache.models.weather.WeatherDetailsCacheModel
import com.halim.data.models.weather.WeatherDetailsEntityModel
import javax.inject.Inject

class WeatherDetailsCacheMapper @Inject constructor (
    private val mainCacheMapper: MainCacheMapper
) :CacheMapper<WeatherDetailsCacheModel,WeatherDetailsEntityModel>{
    override fun mapFromCached(type: WeatherDetailsCacheModel?): WeatherDetailsEntityModel {
        return WeatherDetailsEntityModel(
            dtTxt = type?.dtTxt,
            mainEntity = mainCacheMapper.mapFromCached(type?.mainEntity)
        )
    }

    override fun mapToCached(type: WeatherDetailsEntityModel?): WeatherDetailsCacheModel {
        return WeatherDetailsCacheModel(
            dtTxt = type?.dtTxt,
            mainEntity = mainCacheMapper.mapToCached(type?.mainEntity)
        )
    }
}