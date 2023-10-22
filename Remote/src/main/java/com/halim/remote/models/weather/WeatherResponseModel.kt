package com.halim.data.models.weather

import com.halim.remote.models.RemoteModel


data class WeatherResponseModel(
    val list: List<WeatherDetailsModel>?,
): RemoteModel