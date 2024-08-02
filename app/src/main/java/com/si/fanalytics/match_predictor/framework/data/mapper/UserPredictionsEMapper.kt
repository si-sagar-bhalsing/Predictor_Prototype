package com.si.fanalytics.match_predictor.framework.data.mapper

import com.si.fanalytics.match_predictor.business.domain.model.Answers
import com.si.fanalytics.match_predictor.business.domain.model.Prediction
import com.si.fanalytics.match_predictor.framework.data.model.UserPredictionsE
import javax.inject.Inject

class UserPredictionsEMapper @Inject constructor():EntityMapper<UserPredictionsE,Prediction> {
    override fun toDomain(entity: UserPredictionsE): Prediction {
      return  entity.run {
            Prediction(
                points=this.points,
                rank=this.rank,
                gamedayId=this.gamedayId,
                answers = this.answers.map { Answers(
                    questionId = it.QUESTIONID ?: 0,
                    matchId = it.MATCHID.orEmpty(),
                    isBooster = it.ISBOOSTER ?: 0,
                    matchPoint = it.MHPOINTS.orEmpty(),
                    qTNAnswers = it.QTNANSWER.orEmpty(),
                    optionID = it.OPTIONID ?: 0
                ) },
                matchId = this.matchId,
                retType = this.retType
            )
        }
    }
}