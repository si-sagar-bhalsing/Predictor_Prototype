package com.si.fanalytics.match_predictor.framework.data.mapper

interface EntityMapper<Entity, Domain> {

    fun toEntity(domain: Domain): Entity? {
        return null
    }

    fun toDomain(entity: Entity): Domain?

}