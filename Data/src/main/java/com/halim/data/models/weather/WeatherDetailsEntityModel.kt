package com.halim.data.models.weather

import com.halim.data.models.EntityModel


data class WeatherDetailsEntityModel(
    val dtTxt: String?,
    val mainEntity: MainEntityModel?,
):EntityModel