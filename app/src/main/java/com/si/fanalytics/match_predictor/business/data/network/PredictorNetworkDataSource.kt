package com.si.fanalytics.match_predictor.business.data.network

import com.si.fanalytics.match_predictor.business.data.ApiResult
import com.si.fanalytics.match_predictor.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.response.Fixture
import com.si.fanalytics.match_predictor.business.domain.model.response.Prediction
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.JoinLeagueRequest

interface PredictorNetworkDataSource {
    suspend fun getFixtures(): ApiResult<List<Fixture>>

    suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest): ApiResult<Int>
    suspend fun applyBooster(request : ApplyBoosterRequest): ApiResult<Int>

    suspend fun getUserPredictions():ApiResult<Prediction>

    suspend fun createLeague(request: CreateLeagueRequest):ApiResult<Int>
    suspend fun joinLeague(request: JoinLeagueRequest):ApiResult<Int>
}