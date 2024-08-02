package com.si.fanalytics.match_predictor.framework.data.remote.datasource_impl

import com.si.fanalytics.match_predictor.business.data.ApiResult
import com.si.fanalytics.match_predictor.business.domain.model.Fixture
import com.si.fanalytics.match_predictor.business.data.network.PredictorNetworkDataSource
import com.si.fanalytics.match_predictor.business.data.safeApiCall
import com.si.fanalytics.match_predictor.business.data.toApiResult
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.framework.data.mapper.SubmitPredictionRequestEMapper
import com.si.fanalytics.match_predictor.framework.data.mapper.common.FixtureMapper
import com.si.fanalytics.match_predictor.framework.data.remote.service.PredictorService
import javax.inject.Inject

class PredictorNetworkDataSourceImpl @Inject constructor(
    private val predictorService: PredictorService,
    private val fixtureMapper: FixtureMapper,
    private val submitPredictionRequestEMapper: SubmitPredictionRequestEMapper
):PredictorNetworkDataSource {
    override suspend fun getFixtures(): ApiResult<List<Fixture>> {

        return safeApiCall {
            predictorService.getFixtures(
                url = "predictor/feeds/fixtures/fixtures_1_en.json"
            ).toApiResult{fixtureMapper.toDomain(it)}

        }
    }

    override suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest): ApiResult<Int> {

        return safeApiCall {
            predictorService.submitPrediction(
                url = "afc-asian-cup/predictor/services/api/gameplay/user/a7adcdeac24444588bf63f6004003f3e/user-predict",
                submitPredictionRequest = submitPredictionRequestEMapper.toEntity(
                    submitPredictionRequest
                )
            ).toApiResult { it }
        }
    }
}