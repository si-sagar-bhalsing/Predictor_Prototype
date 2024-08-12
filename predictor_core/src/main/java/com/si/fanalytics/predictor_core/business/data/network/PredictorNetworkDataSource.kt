package com.si.fanalytics.predictor_core.business.data.network


import com.si.fanalytics.predictor_core.business.data.ApiResult
import com.si.fanalytics.predictor_core.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.predictor_core.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.predictor_core.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.predictor_core.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.predictor_core.business.domain.model.response.Fixture
import com.si.fanalytics.predictor_core.business.domain.model.response.Prediction
import com.si.fanalytics.predictor_core.framework.data.model.leagues.response.LeagueResponse

interface PredictorNetworkDataSource {
    suspend fun getFixtures(): ApiResult<List<Fixture>>

    suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest): ApiResult<Int>
    suspend fun applyBooster(request : ApplyBoosterRequest): ApiResult<Int>

    suspend fun getUserPredictions():ApiResult<Prediction>

    suspend fun createLeague(request: CreateLeagueRequest):ApiResult<LeagueResponse>
    suspend fun joinLeague(request: JoinLeagueRequest):ApiResult<LeagueResponse>
}