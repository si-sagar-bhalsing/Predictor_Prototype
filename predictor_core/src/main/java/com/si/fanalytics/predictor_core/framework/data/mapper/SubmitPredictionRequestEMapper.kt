package com.si.fanalytics.predictor_core.framework.data.mapper

import com.si.fanalytics.predictor_core.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.predictor_core.framework.data.model.SubmitPredictionRequestE
import javax.inject.Inject

class SubmitPredictionRequestEMapper @Inject constructor() :EntityMapper<SubmitPredictionRequestE,SubmitPredictionRequest> {
    override fun toDomain(entity: SubmitPredictionRequestE): SubmitPredictionRequest? {
     return   null
    }

    override fun toEntity(domain: SubmitPredictionRequest): SubmitPredictionRequestE {
        return domain.run {
            SubmitPredictionRequestE(
                optType=1,
                tourId=this.tourId,
                soccerMatchId = this.soccerMatchId,
                tourGameDayId=this.tourGameDayId,
                questionId =this.questionId,
                optionId=this.optionId,
                betCoin=this.betCoin,
                platformId=1,
                boosterId=this.boosterId,
                arrTeamId=this.arrTeamId,
            )
        }
    }
}