package com.si.fanalytics.match_predictor.framework.data.remote.datasource_impl

import com.si.fanalytics.match_predictor.business.data.ApiResult
import com.si.fanalytics.match_predictor.business.domain.model.response.Fixture
import com.si.fanalytics.match_predictor.business.data.network.PredictorNetworkDataSource
import com.si.fanalytics.match_predictor.business.data.safeApiCall
import com.si.fanalytics.match_predictor.business.data.toApiResult
import com.si.fanalytics.match_predictor.business.domain.model.response.Prediction
import com.si.fanalytics.match_predictor.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.match_predictor.framework.data.mapper.ApplyBoosterEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.CreateLeagueEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.JoinLeagueEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.SubmitPredictionRequestEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.UserPredictionsEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.FixtureMapper
import com.si.fanalytics.match_predictor.framework.data.model.leagues.response.LeagueResponse
import com.si.fanalytics.match_predictor.framework.data.remote.TextConstant.APPLY_BOOSTER
import com.si.fanalytics.match_predictor.framework.data.remote.TextConstant.CREATE_LEAGUE_URL
import com.si.fanalytics.match_predictor.framework.data.remote.TextConstant.FIXTURE_URL
import com.si.fanalytics.match_predictor.framework.data.remote.TextConstant.JOIN_LEAGUE_URL
import com.si.fanalytics.match_predictor.framework.data.remote.TextConstant.SUBMIT_PREDICTION_URL
import com.si.fanalytics.match_predictor.framework.data.remote.TextConstant.USER_PREDICTIONS_URL
import com.si.fanalytics.match_predictor.framework.data.remote.service.PredictorService
import javax.inject.Inject

class PredictorNetworkDataSourceImpl @Inject constructor(
    private val predictorService: PredictorService,
    private val fixtureMapper: FixtureMapper,
    private val submitPredictionRequestEMapper: SubmitPredictionRequestEMapper,
    private val applyBoosterEMapper: ApplyBoosterEMapper,
    private val userPredictionsEMapper: UserPredictionsEMapper,
    private val createLeagueEMapper: CreateLeagueEMapper,
    private val joinLeagueEMapper: JoinLeagueEMapper
):PredictorNetworkDataSource {
    override suspend fun getFixtures(): ApiResult<List<Fixture>> {

        return safeApiCall {
            predictorService.getFixtures(
                url = FIXTURE_URL
            ).toApiResult{fixtureMapper.toDomain(it)}

        }
    }

    override suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest): ApiResult<Int> {

        return safeApiCall {
            predictorService.submitPrediction(
                url = SUBMIT_PREDICTION_URL,
                submitPredictionRequest = submitPredictionRequestEMapper.toEntity(
                    submitPredictionRequest
                )
            ).toApiResult { it }
        }
    }

    override suspend fun applyBooster(request: ApplyBoosterRequest): ApiResult<Int> {
        return safeApiCall {
            predictorService.applyBooster(
                url = APPLY_BOOSTER,
                applyBoosterRequest = applyBoosterEMapper.toEntity(request)
            ).toApiResult { it }
        }
    }

    override suspend fun getUserPredictions(): ApiResult<Prediction> {
        return safeApiCall {
            predictorService.getUserPredictions(
                url = USER_PREDICTIONS_URL
            ).toApiResult {  userPredictionsEMapper.toDomain(it) }
        }
    }

    override suspend fun createLeague(request: CreateLeagueRequest): ApiResult<LeagueResponse> {
        return safeApiCall {
            predictorService.createLeague(
                url =CREATE_LEAGUE_URL ,
                createLeagueRequest =createLeagueEMapper.toEntity(request)
            ).toApiResult { it }
        }
    }

    override suspend fun joinLeague(request: JoinLeagueRequest): ApiResult<LeagueResponse> {
        return safeApiCall {
            predictorService.joinLeague(
                url = JOIN_LEAGUE_URL,
                joinLeagueRequest = joinLeagueEMapper.toEntity(request)
            ).toApiResult { it }
        }
    }
}