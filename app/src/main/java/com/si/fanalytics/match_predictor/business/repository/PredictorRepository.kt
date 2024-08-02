package com.si.fanalytics.match_predictor.business.repository

import com.si.fanalytics.match_predictor.business.domain.model.response.Fixture
import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.domain.model.response.Prediction
import com.si.fanalytics.match_predictor.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.JoinLeagueRequest

interface PredictorRepository {
    suspend fun getFixtures(): Resource<List<Fixture>>
    suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest):Resource<Int>
    suspend fun applyBooster(request: ApplyBoosterRequest):Resource<Int>
    suspend fun getUserPredictions():Resource<Prediction>

    suspend fun createLeague(request:CreateLeagueRequest):Resource<Int>
    suspend fun joinLeague(request: JoinLeagueRequest):Resource<Int>
}