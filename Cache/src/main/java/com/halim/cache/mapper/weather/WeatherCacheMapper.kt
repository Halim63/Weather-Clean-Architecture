package com.halim.cache.mapper.weather

import com.halim.cache.mapper.CacheMapper
import com.halim.cache.models.weather.WeatherCacheModel
import com.halim.data.models.weather.WeatherEntityModel
import javax.inject.Inject

class WeatherCacheMapper (
    private val weatherDetailsCacheMapper: WeatherDetailsCacheMapper
) : CacheMapper<WeatherCacheModel, WeatherEntityModel> {
    override fun mapFromCached(type: WeatherCacheModel?): WeatherEntityModel {
        return WeatherEntityModel(
          list = type?.list?.map {
              weatherDetailsCacheModel -> weatherDetailsCacheMapper.mapFromCached(weatherDetailsCacheModel)
          }
        )
    }

    override fun mapToCached(type: WeatherEntityModel?): WeatherCacheModel {
        return WeatherCacheModel(
            list = type?.list?.map {
                weatherDetailsEntityModel ->
                weatherDetailsCacheMapper.mapToCached(weatherDetailsEntityModel)
            }
        )
    }


}