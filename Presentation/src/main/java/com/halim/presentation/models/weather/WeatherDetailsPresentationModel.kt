package com.halim.presentation.models.weather

import com.halim.presentation.models.PresentationModel


data class WeatherDetailsPresentationModel(
    val dtTxt: String?,
    val mainEntity: MainPresentationModel?,
):PresentationModel