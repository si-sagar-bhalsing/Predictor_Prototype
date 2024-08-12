package com.si.fanalytics.predictor_core.framework.data.mapper

import com.si.fanalytics.predictor_core.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.predictor_core.framework.data.model.leagues.request.CreateLeagueRequestE
import com.si.fanalytics.predictor_core.framework.data.remote.TextConstant.LANGUAGE

import javax.inject.Inject

class CreateLeagueEMapper @Inject constructor():EntityMapper<CreateLeagueRequestE,CreateLeagueRequest> {

    override fun toEntity(domain: CreateLeagueRequest): CreateLeagueRequestE {
        return domain.run {
            CreateLeagueRequestE(
                optType=this.optType,
                gamedayId=this.gamedayId,
                leagueName=this.leagueName,
                leagueCode=this.leagueCode,
                leagueId=this.leagueId,
                language = LANGUAGE,
                tourId = this.tourId
            )
        }
    }

    override fun toDomain(entity: CreateLeagueRequestE): CreateLeagueRequest? {
       return null
    }
}