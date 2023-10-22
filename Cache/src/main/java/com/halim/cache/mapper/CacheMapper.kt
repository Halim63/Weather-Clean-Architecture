package com.halim.cache.mapper

import com.halim.cache.models.CacheModel
import com.halim.data.models.EntityModel

interface CacheMapper<C : CacheModel, E : EntityModel> {

    fun mapFromCached(type: C?): E

    fun mapToCached(type: E?): C
}