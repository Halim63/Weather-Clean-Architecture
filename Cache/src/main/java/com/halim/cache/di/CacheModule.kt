package com.halim.cache.di

import androidx.room.Room
import com.halim.cache.WeatherCacheImp
import com.halim.cache.db.WeatherDao
import com.halim.cache.db.WeatherDatabase
import com.halim.cache.mapper.weather.MainCacheMapper
import com.halim.cache.mapper.weather.WeatherCacheMapper
import com.halim.cache.mapper.weather.WeatherDetailsCacheMapper
import com.halim.data.repository.weather.WeatherCache
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cacheModule = module{

    /**
     * CacheModel mappers
     */
    factory { WeatherCacheMapper(get()) }
    factory { WeatherDetailsCacheMapper(get()) }
    factory { MainCacheMapper() }


    /**
     * Cache repositories
     */
    single<WeatherCache> { WeatherCacheImp(get(),get()) }


    /**
     * DB
     */

    single {
        Room.databaseBuilder(
            androidApplication(),
            WeatherDatabase::class.java,
            "weather_database"
        ).build()
    }

    /**
     * DAO
     */

    single<WeatherDao> {
        val database = get<WeatherDatabase>()
        database.getDBWeather()
    }
 }
