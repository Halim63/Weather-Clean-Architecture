package com.halim.cache

//import com.halim.cache.db.WeatherDatabase
import com.halim.cache.db.WeatherDatabase
import com.halim.cache.mapper.weather.WeatherDetailsCacheMapper
import com.halim.data.models.weather.WeatherEntityModel
import com.halim.data.repository.weather.WeatherCache
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WeatherCacheImp @Inject constructor(
    private val weatherDatabase: WeatherDatabase,
    private val mapper: WeatherDetailsCacheMapper

) : WeatherCache {
    override fun getWeather(): Observable<WeatherEntityModel> {
//        return weatherDatabase.getDBWeather().getWeather()
        TODO("Not yet implemented")

    }

    override fun clearWeather(): Completable {
        TODO("Not yet implemented")
    }

    override fun saveWeather(weatherEntity: WeatherEntityModel): Completable {
        TODO("Not yet implemented")
    }

    override fun areWeatherCached(): Single<Boolean> {
        TODO("Not yet implemented")
    }

    override fun isWeatherCachedExpired(): Single<Boolean> {
        TODO("Not yet implemented")
    }
}