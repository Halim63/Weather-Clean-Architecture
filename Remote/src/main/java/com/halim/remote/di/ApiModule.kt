package com.halim.remote.di


import com.halim.data.repository.weather.WeatherRemote
import com.halim.remote.ApiKeyInterceptor
import com.halim.remote.WeatherRemoteImpl
import com.halim.remote.mapper.weather.WeatherDetailsModelMapper
import com.halim.remote.service.WeatherApiServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"


    var retrofit: Retrofit = createRetrofitInstance()

    @Provides
    @Singleton
    fun createRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createInterceptor())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton

    fun createInterceptor(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(ApiKeyInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRepo(
        weatherApiServiceInterface: WeatherApiServiceInterface,
        mapper: WeatherDetailsModelMapper,
    ): WeatherRemote {
        return WeatherRemoteImpl(weatherApiServiceInterface, mapper)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): WeatherApiServiceInterface{
        return retrofit.create(WeatherApiServiceInterface::class.java)
    }




}