package com.halim.presentation.models.weather

import com.halim.presentation.models.PresentationModel

data class WeatherPresentationModel(
    val list: List<WeatherDetailsPresentationModel>?,
): PresentationModel