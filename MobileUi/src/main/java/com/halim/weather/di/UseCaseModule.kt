package com.halim.weather.di

import com.halim.domain.executor.PostExecutionThread
import com.halim.domain.repository.WeatherRepository
import com.halim.domain.usecases.GetWeatherUsecase
import com.halim.presentation.PostExecutionThreadImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(weatherRepository: WeatherRepository, postExecutionThread: PostExecutionThread): GetWeatherUsecase{
        return GetWeatherUsecase(weatherRepository,postExecutionThread)
    }



}
@Module
@InstallIn(SingletonComponent::class)
internal abstract class ExecutionThreadModule{
    @Binds
    abstract fun postExecution(postExecutionThreadImpl: PostExecutionThreadImpl):PostExecutionThread
}

