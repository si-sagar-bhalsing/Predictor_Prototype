package com.si.fanalytics.match_predictor.framework.data.mapper

import com.si.fanalytics.match_predictor.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.match_predictor.framework.data.model.leagues.request.JoinLeagueRequestE
import com.si.fanalytics.match_predictor.framework.data.remote.TextConstant.LANGUAGE
import javax.inject.Inject

class JoinLeagueEMapper @Inject constructor() :EntityMapper<JoinLeagueRequestE,JoinLeagueRequest> {
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