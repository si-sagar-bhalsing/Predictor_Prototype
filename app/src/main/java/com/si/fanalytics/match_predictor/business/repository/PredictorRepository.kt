package com.si.fanalytics.match_predictor.business.repository

import com.si.fanalytics.match_predictor.business.domain.model.Fixture
import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.domain.model.Prediction
import com.si.fanalytics.match_predictor.business.domain.model.Requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest

interface PredictorRepository {
    suspend fun getFixtures(): Resource<List<Fixture>>
    suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest):Resource<Int>
    suspend fun applyBooster(request: ApplyBoosterRequest):Resource<Int>
    suspend fun getUserPredictions():Resource<Prediction>
}