package com.halim.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.halim.domain.usecases.GetWeatherUsecase
import com.halim.presentation.base.Resource
import com.halim.presentation.base.State
import com.halim.presentation.mapper.weather.WeatherDetailsPresentationMapper
import com.halim.presentation.models.weather.WeatherDetailsPresentationModel
import com.halim.presentation.models.weather.WeatherPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUsecase: GetWeatherUsecase,
    private val weatherDetailsPresentationMapper: WeatherDetailsPresentationMapper,

    ) : ViewModel() {

    private val _weatherLiveData = MutableLiveData<Resource<WeatherDetailsPresentationModel?>>()
    val weatherLiveData: LiveData<Resource<WeatherDetailsPresentationModel?>> = _weatherLiveData
    val liveData  = MutableLiveData<WeatherPresentationModel>()


    private val compositeDisposable = CompositeDisposable()


    fun getWeather() {
        compositeDisposable.add(
            getWeatherUsecase.getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {it.list?.map {model->
                        _weatherLiveData.postValue(Resource.success(
                            weatherDetailsPresentationMapper.mapToView(model)
                        ))
                        Log.d("zxc", model.dtTxt.toString())
                    }



                    },
                    {
                        _weatherLiveData.postValue(Resource.error(message = State.ERROR.toString()))

                    }
                )
        )

    }
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()

    }


}