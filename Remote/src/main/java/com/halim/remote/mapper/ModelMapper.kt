package com.halim.remote.mapper

import com.halim.data.models.EntityModel
import com.halim.remote.models.RemoteModel

interface ModelMapper<M: RemoteModel, E:EntityModel > {

    fun mapFromModel(model: M?): E
}