package com.halim.data.models.weather

import com.halim.data.models.EntityModel

data class WeatherEntityModel(
    val list: List<WeatherDetailsEntityModel>?,
): EntityModel