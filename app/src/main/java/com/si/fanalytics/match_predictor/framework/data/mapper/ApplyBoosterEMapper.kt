package com.si.fanalytics.match_predictor.framework.data.mapper

import com.si.fanalytics.match_predictor.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.framework.data.model.ApplyBoosterRequestE
import javax.inject.Inject

class ApplyBoosterEMapper @Inject constructor():EntityMapper<ApplyBoosterRequestE, ApplyBoosterRequest> {
    override fun toEntity(domain: ApplyBoosterRequest): ApplyBoosterRequestE {
        return domain.run {
            ApplyBoosterRequestE(
                opt_type=this.optType,
                tourid = this.tourId,
                soccer_matchid = this.soccerMatchId,
                tour_gamedayid = this.tourGameDayId,
                platformid =1,
                boosterid = this.boosterId,

            )
        }
    }

    override fun toDomain(entity: ApplyBoosterRequestE): ApplyBoosterRequest? {
        return null
    }
}