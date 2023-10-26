package com.halim.presentation.models.weather

import androidx.room.PrimaryKey
import com.halim.presentation.models.PresentationModel


data class WeatherDetailsPresentationModel(
    val dtTxt: String?,
    val mainEntity: MainPresentationModel?,
    @PrimaryKey(autoGenerate = true)
    val id: Int? =null
):PresentationModel