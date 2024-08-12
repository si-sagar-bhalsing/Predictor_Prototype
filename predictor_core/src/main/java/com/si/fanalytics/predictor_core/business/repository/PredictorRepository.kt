package com.si.fanalytics.predictor_core.business.repository

import com.si.fanalytics.predictor_core.business.data.utils.Resource
import com.si.fanalytics.predictor_core.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.predictor_core.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.predictor_core.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.predictor_core.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.predictor_core.business.domain.model.response.Fixture
import com.si.fanalytics.predictor_core.business.domain.model.response.Prediction
import com.si.fanalytics.predictor_core.framework.data.model.leagues.response.LeagueResponse


interface PredictorRepository {
    suspend fun getFixtures(): Resource<List<Fixture>>
    suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest):Resource<Int>
    suspend fun applyBooster(request: ApplyBoosterRequest):Resource<Int>
    suspend fun getUserPredictions(): Resource<Prediction>

    suspend fun createLeague(request: CreateLeagueRequest):Resource<LeagueResponse>
    suspend fun joinLeague(request: JoinLeagueRequest):Resource<LeagueResponse>
}