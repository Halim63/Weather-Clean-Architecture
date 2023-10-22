package com.halim.domain.models.weather

import com.halim.domain.models.DomainModel


data class Weather(
    val list: List<WeatherDetails>?,
):DomainModel