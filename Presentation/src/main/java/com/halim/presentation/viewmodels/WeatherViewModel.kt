package com.halim.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.halim.domain.models.weather.Weather
import com.halim.domain.usecases.GetWeatherUsecase
import com.halim.presentation.base.BaseViewModel
import com.halim.presentation.base.Resource
import com.halim.presentation.base.ResourceState
import com.halim.presentation.mapper.weather.WeatherPresentationMapper
import com.halim.presentation.models.weather.WeatherPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableObserver
import javax.inject.Inject

class WeatherViewModel (
    private val getWeatherUsecase: GetWeatherUsecase,
    private val weatherPresentationMapper: WeatherPresentationMapper
) : BaseViewModel() {
    private val weatherLiveData: MutableLiveData<Resource<WeatherPresentationModel>> =
        MutableLiveData()

    fun getWeatherLiveData(): LiveData<Resource<WeatherPresentationModel>> {
        return weatherLiveData
    }

    fun fetchData() {
        weatherLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getWeatherUsecase.execute(WeatherSubscriber())
    }

    inner class WeatherSubscriber : DisposableObserver<Weather>() {
        override fun onNext(t: Weather) {
            weatherLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                  weatherPresentationMapper.mapToView(t)
                    , null

                )
            )
        }

        override fun onError(e: Throwable) {
            weatherLiveData.postValue(Resource(ResourceState.ERROR, null, e))
        }

        override fun onComplete() {}

    }

}