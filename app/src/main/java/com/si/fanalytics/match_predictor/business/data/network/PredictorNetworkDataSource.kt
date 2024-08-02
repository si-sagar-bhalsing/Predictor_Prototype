package com.si.fanalytics.match_predictor.business.data.network

import com.si.fanalytics.match_predictor.business.data.ApiResult
import com.si.fanalytics.match_predictor.business.domain.model.Fixture
import com.si.fanalytics.match_predictor.business.domain.model.PredictorModel
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.framework.data.model.fixture.FixtureE

interface PredictorNetworkDataSource {
    suspend fun getFixtures(): ApiResult<List<Fixture>>

    suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest): ApiResult<Int>
}