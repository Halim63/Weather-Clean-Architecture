package com.halim.data.mapper

interface EntityMapper<E , D > {
    fun mapFromEntity(entity: E?): D // to Domain (Domain Module)
    fun mapToEntity(domain: D?): E // to Domain (Domain Module)
}