package com.halim.presentation.models.weather

import androidx.room.PrimaryKey
import com.halim.domain.models.weather.WeatherDetails
import com.halim.presentation.models.PresentationModel

data class WeatherPresentationModel(
    val list: List<WeatherDetailsPresentationModel>?,

    ):PresentationModel {

}