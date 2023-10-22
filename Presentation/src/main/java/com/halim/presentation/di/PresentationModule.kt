package com.halim.presentation.di

import com.halim.domain.executor.PostExecutionThread
import com.halim.presentation.mapper.weather.MainPresentationMapper
import com.halim.presentation.mapper.weather.WeatherDetailsPresentationMapper
import com.halim.presentation.mapper.weather.WeatherPresentationMapper
import com.halim.presentation.viewmodels.WeatherViewModel
import com.halim.presentation.PostExecutionThreadImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single<PostExecutionThread> { PostExecutionThreadImpl() }


    factory { WeatherPresentationMapper(get()) }
    factory { WeatherDetailsPresentationMapper(get()) }
    factory { MainPresentationMapper() }


    viewModel { WeatherViewModel(get(),get()) }
}