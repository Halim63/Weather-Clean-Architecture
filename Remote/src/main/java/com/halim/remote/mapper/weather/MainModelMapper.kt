package com.halim.remote.mapper.weather

import com.halim.data.models.weather.MainEntityModel
import com.halim.data.models.weather.MainModel
import com.halim.remote.mapper.ModelMapper
import javax.inject.Inject

class MainModelMapper @Inject constructor() : ModelMapper<MainModel, MainEntityModel> {
    override fun mapFromModel(model: MainModel?): MainEntityModel {
        return MainEntityModel(
            temp = model?.temp
        )
    }
}