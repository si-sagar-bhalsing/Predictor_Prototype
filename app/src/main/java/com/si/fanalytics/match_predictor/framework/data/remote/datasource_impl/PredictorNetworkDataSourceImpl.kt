package com.si.fanalytics.match_predictor.framework.data.remote.datasource_impl

import com.si.fanalytics.match_predictor.business.data.ApiResult
import com.si.fanalytics.match_predictor.business.domain.model.Fixture
import com.si.fanalytics.match_predictor.business.data.network.PredictorNetworkDataSource
import com.si.fanalytics.match_predictor.business.data.safeApiCall
import com.si.fanalytics.match_predictor.business.data.toApiResult
import com.si.fanalytics.match_predictor.business.domain.model.Prediction
import com.si.fanalytics.match_predictor.business.domain.model.Requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.framework.data.mapper.ApplyBoosterEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.SubmitPredictionRequestEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.UserPredictionsEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.common.FixtureMapper
import com.si.fanalytics.match_predictor.framework.data.remote.TextConsntant.APPLY_BOOSTER
import com.si.fanalytics.match_predictor.framework.data.remote.TextConsntant.FIXTURE_URL
import com.si.fanalytics.match_predictor.framework.data.remote.TextConsntant.SUBMIT_PREDICTION_URL
import com.si.fanalytics.match_predictor.framework.data.remote.TextConsntant.USER_PREDICTIONS_URL
import com.si.fanalytics.match_predictor.framework.data.remote.service.PredictorService
import javax.inject.Inject

class PredictorNetworkDataSourceImpl @Inject constructor(
    private val predictorService: PredictorService,
    private val fixtureMapper: FixtureMapper,
    private val submitPredictionRequestEMapper: SubmitPredictionRequestEMapper,
    private val applyBoosterEMapper: ApplyBoosterEMapper,
    private val userPredictionsEMapper: UserPredictionsEMapper
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
}