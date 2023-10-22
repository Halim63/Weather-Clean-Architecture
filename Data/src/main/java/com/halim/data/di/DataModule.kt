package com.halim.data.di

import com.halim.data.mapper.weather.MainEntityMapper
import com.halim.data.mapper.weather.WeatherDetailsMapper
import com.halim.data.mapper.weather.WeatherEntityMapper
import com.halim.data.repository.WeatherDataRepoImpl
import com.halim.data.store.WeatherCacheDataStore
import com.halim.data.store.WeatherDataStoreFactory
import com.halim.data.store.WeatherRemoteDataStore
import com.halim.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    factory { WeatherEntityMapper(get()) }
    factory { WeatherDetailsMapper(get()) }
    factory { MainEntityMapper() }



    single { WeatherRemoteDataStore(get()) }
    single { WeatherCacheDataStore(get()) }
    single { WeatherDataStoreFactory(get(),get()) }
    single<WeatherRepository> { WeatherDataRepoImpl(get(), get(),get() ) }

}