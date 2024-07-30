package com.si.fanalytics.match_predictor.data

import com.si.fanalytics.match_predictor.data.model.PredictorModel

internal interface MatchRepository {
    suspend fun getFixtures(): ApiResult<PredictorModel>
}
