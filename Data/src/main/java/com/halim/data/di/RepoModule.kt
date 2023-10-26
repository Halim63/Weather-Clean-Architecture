package com.halim.data.di

import com.halim.data.mapper.weather.WeatherDetailsEntityMapper
import com.halim.data.repository.WeatherDataRepoImpl
import com.halim.data.repository.weather.WeatherCache
import com.halim.data.store.WeatherDataStoreFactory
import com.halim.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideCacheRepo(
        mapper: WeatherDetailsEntityMapper,
        factory: WeatherDataStoreFactory,
        cache: WeatherCache,
    ): WeatherRepository {
        return WeatherDataRepoImpl(mapper, factory, cache)
    }
}