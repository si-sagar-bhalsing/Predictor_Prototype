package com.gaming.core.data

import com.gaming.core.data.model.PredictorModel

internal interface MatchRepository {
    suspend fun getFixtures(): ApiResult<PredictorModel>
}
