package com.halim.remote.di

import com.halim.data.repository.weather.WeatherRemote
import com.halim.domain.repository.WeatherRepository
import com.halim.remote.WeatherRemoteImpl
import com.halim.remote.mapper.weather.MainModelMapper
import com.halim.remote.mapper.weather.WeatherDetailsModelMapper
import com.halim.remote.mapper.weather.WeatherResponseModelMapper
import com.halim.remote.service.WeatherApiServiceInterface
import org.koin.dsl.module

val remoteModule = module {

    /**
     * RemoteModel mappers
     */
    factory { WeatherResponseModelMapper(get()) }
    factory { WeatherDetailsModelMapper(get()) }
    factory { MainModelMapper() }


    /**
     * Remote repositories
     */
    single<WeatherRemote> { WeatherRemoteImpl(get(),get()) }


    /**
     * Retrofit services
     */
    single { ApiModule.create(WeatherApiServiceInterface::class.java) }

}
