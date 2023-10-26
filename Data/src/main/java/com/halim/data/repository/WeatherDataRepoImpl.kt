package com.halim.data.repository

import com.halim.data.mapper.weather.WeatherDetailsEntityMapper
import com.halim.data.repository.weather.WeatherCache
import com.halim.data.store.WeatherDataStoreFactory
import com.halim.domain.models.weather.Weather
import com.halim.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import javax.inject.Inject

class WeatherDataRepoImpl @Inject constructor(
    val mapper: WeatherDetailsEntityMapper,
    private val factory: WeatherDataStoreFactory,
    val cache: WeatherCache,
) : WeatherRepository {
    override fun getWeather(): Observable<Weather> {
        return Observable.zip(cache.areWeatherCached().toObservable(),
            cache.isWeatherCachedExpired().toObservable()){ areCached, isExpired ->
            Pair(areCached, isExpired)
        }
            .flatMap {
                factory.getDataStore(it.first,it.second).getWeather()
            }
            .flatMap {
                factory.getWeatherCacheDataStore().getWeather()
                    .flatMap{model->
                return@flatMap ObservableSource {
                       model.list?.map { entity->
                            mapper.mapFromEntity(entity)
                        }


                }
            }
            }
    }
//        factory.getWeatherCacheDataStore().getWeather()
//            .flatMap{model->
//                return@flatMap ObservableSource {
//                       model.list?.map { entity->
//                            mapper.mapFromEntity(entity)
//                        }
//
//
//                }
//            }


}
