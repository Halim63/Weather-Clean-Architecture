package com.halim.presentation.mapper

import com.halim.domain.models.DomainModel
import com.halim.presentation.models.PresentationModel

interface PresentationMapper<V : PresentationModel, D : DomainModel> {
    fun mapToView(type: D?): V
}