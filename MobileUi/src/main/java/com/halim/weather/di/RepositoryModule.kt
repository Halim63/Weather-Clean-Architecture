package com.halim.weather.di

import com.halim.data.mapper.weather.WeatherEntityMapper
import com.halim.data.repository.WeatherDataRepoImpl
import com.halim.data.repository.weather.WeatherCache
import com.halim.data.repository.weather.WeatherDataStore
import com.halim.data.store.WeatherCacheDataStore
import com.halim.data.store.WeatherDataStoreFactory
import com.halim.domain.repository.WeatherRepository
import com.halim.domain.usecases.GetWeatherUsecase
import com.halim.remote.service.WeatherApiServiceInterface
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo( mapper: WeatherEntityMapper,  factory: WeatherDataStoreFactory,  cache: WeatherCache
    ): WeatherRepository{
        return WeatherDataRepoImpl(mapper,factory,cache)
    }
@Provides
    fun provideCache(cache: WeatherCache):WeatherDataStore{
        return WeatherCacheDataStore(cache)
    }
}