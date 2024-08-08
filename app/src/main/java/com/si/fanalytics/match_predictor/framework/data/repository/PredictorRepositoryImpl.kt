package com.si.fanalytics.match_predictor.framework.data.repository

import com.si.fanalytics.match_predictor.business.domain.model.response.Fixture
import com.si.fanalytics.match_predictor.business.data.network.PredictorNetworkDataSource
import com.si.fanalytics.match_predictor.business.data.utils.ApiResultHandler
import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.domain.model.response.Prediction
import com.si.fanalytics.match_predictor.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.match_predictor.business.repository.PredictorRepository
import com.si.fanalytics.match_predictor.framework.data.model.leagues.response.LeagueResponse
import javax.inject.Inject

class PredictorRepositoryImpl @Inject constructor(
    private val predictorNetworkDataSource: PredictorNetworkDataSource
) :PredictorRepository {
    override suspend fun getFixtures(): Resource<List<Fixture>> {
        val  result=predictorNetworkDataSource.getFixtures()

        val resource= object : ApiResultHandler<List<Fixture>, List<Fixture>>(result) {
            override suspend fun handleSuccess(resultObj: List<Fixture>): Resource<List<Fixture>> {
                return Resource.Success(resultObj)
            }
        }.getResult()
        
        return resource
    }

    override suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest): Resource<Int> {
        val result = predictorNetworkDataSource.submitPrediction(submitPredictionRequest)

        val resource=object :ApiResultHandler<Int,Int>(result){
            override suspend fun handleSuccess(resultObj: Int): Resource<Int> {
                return Resource.Success(resultObj)
            }
        }.getResult()

        return resource
    }

    override suspend fun applyBooster(request: ApplyBoosterRequest): Resource<Int> {
        val result= predictorNetworkDataSource.applyBooster(request=request)
        val resource= object : ApiResultHandler<Int,Int>(result) {
            override suspend fun handleSuccess(resultObj: Int): Resource<Int> {
                return Resource.Success(resultObj)
            }
        }.getResult()

        return resource
    }

    override suspend fun getUserPredictions(): Resource<Prediction> {
        val result=predictorNetworkDataSource.getUserPredictions()

        val resource=object :ApiResultHandler<Prediction, Prediction>(result){
            override suspend fun handleSuccess(resultObj: Prediction): Resource<Prediction> {
               return Resource.Success(resultObj)
            }
        }.getResult()
        return resource
    }

    override suspend fun createLeague(request: CreateLeagueRequest): Resource<LeagueResponse> {
        val result = predictorNetworkDataSource.createLeague(request = request)

        val resource = object : ApiResultHandler<LeagueResponse, LeagueResponse>(result) {
            override suspend fun handleSuccess(resultObj: LeagueResponse): Resource<LeagueResponse> {
                return Resource.Success(resultObj)
            }
        }.getResult()

        return resource
    }

    override suspend fun joinLeague(request: JoinLeagueRequest): Resource<LeagueResponse> {
        val result = predictorNetworkDataSource.joinLeague(request = request)
        val resource = object : ApiResultHandler<LeagueResponse, LeagueResponse>(result) {
            override suspend fun handleSuccess(resultObj: LeagueResponse): Resource<LeagueResponse> {
                return Resource.Success(resultObj)
            }
        }.getResult()
        return resource
    }
}
