package com.halim.cache.mapper.weather

import com.halim.cache.mapper.CacheMapper
import com.halim.cache.models.weather.MainCacheModel
import com.halim.data.models.weather.MainEntityModel
import javax.inject.Inject

class MainCacheMapper() : CacheMapper<MainCacheModel, MainEntityModel> {
    override fun mapFromCached(type: MainCacheModel?): MainEntityModel {
        return MainEntityModel(
            type?.temp
        )
    }

    override fun mapToCached(type: MainEntityModel?): MainCacheModel {
        return MainCacheModel(type?.temp)
    }
}