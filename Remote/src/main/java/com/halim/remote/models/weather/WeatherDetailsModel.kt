package com.halim.data.models.weather

import com.halim.remote.models.RemoteModel


data class WeatherDetailsModel(
    val dtTxt: String?,
    val mainEntity: MainModel?,
): RemoteModel