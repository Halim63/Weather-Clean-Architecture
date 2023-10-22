package com.halim.presentation.mapper.weather

import com.halim.domain.models.weather.WeatherDetails
import com.halim.presentation.mapper.PresentationMapper
import com.halim.presentation.models.weather.WeatherDetailsPresentationModel
import javax.inject.Inject

class WeatherDetailsPresentationMapper @Inject constructor(
    private val mainPresentationMapper: MainPresentationMapper
):PresentationMapper<WeatherDetailsPresentationModel,WeatherDetails> {
    override fun mapToView(type: WeatherDetails?): WeatherDetailsPresentationModel {
        return WeatherDetailsPresentationModel(
            dtTxt = type?.dtTxt,
            mainEntity = mainPresentationMapper.mapToView(type?.main)
        )
    }
}