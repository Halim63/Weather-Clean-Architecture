package com.halim.data.mapper.weather

import com.halim.data.mapper.EntityMapper
import com.halim.data.models.weather.MainEntityModel
import com.halim.domain.models.weather.Main
import javax.inject.Inject

class MainEntityMapper @Inject constructor(

) : EntityMapper<MainEntityModel, Main> {


    override fun mapFromEntity(entity: MainEntityModel?): Main {
        return Main(
            temp = entity?.temp
        )
    }

    override fun mapToEntity(domain: Main?): MainEntityModel {
        return MainEntityModel(
            temp = domain?.temp
        )
    }
}