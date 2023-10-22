package com.halim.domain.di

import com.halim.domain.usecases.GetWeatherUsecase
import org.koin.dsl.module

val domainModule = module {

    factory { GetWeatherUsecase(get(),get()) }
}