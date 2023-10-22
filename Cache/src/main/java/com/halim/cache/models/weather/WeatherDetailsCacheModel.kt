package com.halim.cache.models.weather

import com.halim.cache.models.CacheModel


data class WeatherDetailsCacheModel(
    val dtTxt: String?,
    val mainEntity: MainCacheModel?,
):CacheModel