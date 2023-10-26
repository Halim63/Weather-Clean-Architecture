package com.halim.cache

import com.halim.cache.db.WeatherDatabase
import com.halim.cache.mapper.weather.WeatherCacheMapper
import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.repository.weather.WeatherCache
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import javax.inject.Inject

class WeatherCacheImp @Inject constructor (
    private val weatherDatabase: WeatherDatabase,
    private val mapper: WeatherCacheMapper,

    ) : WeatherCache {
    override fun getWeather(): Observable<WeatherEntityModel> {
        return weatherDatabase.getDBWeather().getAllWeather()

            .flatMap {list->

                    return@flatMap ObservableSource {
                    list.map {model->
                        mapper.mapFromCached(model)
                    }

                }
            }

    }


}