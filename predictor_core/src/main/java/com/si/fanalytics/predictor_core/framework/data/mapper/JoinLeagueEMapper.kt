package com.si.fanalytics.predictor_core.framework.data.mapper

import com.si.fanalytics.predictor_core.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.predictor_core.framework.data.model.leagues.request.JoinLeagueRequestE
import com.si.fanalytics.predictor_core.framework.data.remote.TextConstant.LANGUAGE

import javax.inject.Inject

class JoinLeagueEMapper @Inject constructor() :EntityMapper<JoinLeagueRequestE, JoinLeagueRequest> {
    override fun toEntity(domain: JoinLeagueRequest): JoinLeagueRequestE {
        return domain.run {
            JoinLeagueRequestE(
                optType=this.optType,
                leagueId=this.leagueId,
                leagueName = this.leagueName,
                leagueCode = this.leagueCode,
                gamedayId = this.gamedayId,
                language = LANGUAGE,
                tourId = this.tourId

            )
        }
    }

    override fun toDomain(entity: JoinLeagueRequestE): JoinLeagueRequest? {
       return null
    }
}