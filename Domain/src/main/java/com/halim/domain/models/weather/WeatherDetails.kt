package com.halim.domain.models.weather

import com.halim.domain.models.DomainModel


data class WeatherDetails(
    val dtTxt: String?,
    val main: Main?,
):DomainModel