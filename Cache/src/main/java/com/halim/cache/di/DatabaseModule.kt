package com.halim.cache.di

import android.app.Application
import androidx.room.Room
import com.halim.cache.WeatherCacheImp
import com.halim.cache.db.WeatherDao
import com.halim.cache.db.WeatherDatabase
import com.halim.cache.mapper.weather.WeatherCacheMapper
import com.halim.data.repository.weather.WeatherCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDB(context: Application): WeatherDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            WeatherDatabase::class.java,
            "image_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideImageDao(weatherDatabase: WeatherDatabase): WeatherDao {
        return weatherDatabase.getDBWeather()
    }

    @Provides
    fun provideRepo(weatherDatabase:WeatherDatabase,mapper: WeatherCacheMapper): WeatherCache{
        return WeatherCacheImp(weatherDatabase,mapper)
    }
}