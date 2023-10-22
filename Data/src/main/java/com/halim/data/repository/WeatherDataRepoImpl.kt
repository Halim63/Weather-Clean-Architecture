package com.halim.data.repository

import com.halim.data.mapper.weather.WeatherEntityMapper
import com.halim.data.repository.weather.WeatherCache
import com.halim.data.store.WeatherDataStoreFactory
import com.halim.domain.models.weather.Weather
import com.halim.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import retrofit2.Response
import javax.inject.Inject

class WeatherDataRepoImpl (
    val mapper: WeatherEntityMapper,
    val factory: WeatherDataStoreFactory,
    val cache: WeatherCache
) : WeatherRepository {
    override fun getWeather(): Observable<Weather>{
        return Observable.zip(cache.areWeatherCached().toObservable(),
            cache.isWeatherCachedExpired().toObservable()
        ) { areCached, isExpired ->
            Pair(areCached, isExpired)
        }
            .flatMap {
                factory.getDataStore(it.first,it.second).getWeather()
            }

            .flatMap {weatherEntity->
                factory.getWeatherCacheDataStore()
                    .saveWeather(weatherEntity)
                    .andThen(Observable.just(weatherEntity))
            }
            .map {
                  mapper.mapFromEntity(it)
                }
            }


    }
