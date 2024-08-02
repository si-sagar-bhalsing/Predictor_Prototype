package com.si.fanalytics.match_predictor.business.data.network

import com.si.fanalytics.match_predictor.business.data.ApiResult
import com.si.fanalytics.match_predictor.business.domain.model.Requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.Fixture
import com.si.fanalytics.match_predictor.business.domain.model.Prediction
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest

interface PredictorNetworkDataSource {
    suspend fun getFixtures(): ApiResult<List<Fixture>>

    suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest): ApiResult<Int>
    suspend fun applyBooster(request : ApplyBoosterRequest): ApiResult<Int>

    suspend fun getUserPredictions():ApiResult<Prediction>
}