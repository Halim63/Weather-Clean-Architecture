package com.halim.presentation.mapper.weather

import com.halim.domain.models.weather.Main
import com.halim.presentation.mapper.PresentationMapper
import com.halim.presentation.models.weather.MainPresentationModel
import javax.inject.Inject

class MainPresentationMapper @Inject constructor():PresentationMapper<MainPresentationModel,Main>  {


    override fun mapToView(type: Main?): MainPresentationModel {
        return MainPresentationModel(
            temp = type?.temp
        )    }
}