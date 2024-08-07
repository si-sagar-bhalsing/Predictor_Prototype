package com.si.fanalytics.match_predictor.data.repository

import com.si.fanalytics.match_predictor.data.ApiResult
import com.si.fanalytics.match_predictor.data.MatchRepository
import com.si.fanalytics.match_predictor.data.RetrofitInstance
import com.si.fanalytics.match_predictor.data.interactor.PredictorModelMapper
import com.si.fanalytics.match_predictor.data.model.PredictorModel
import com.si.fanalytics.match_predictor.data.safeApiCall

class MatchRepositoryImp(private val mapper: PredictorModelMapper) : MatchRepository {
    override suspend fun getFixtures(): ApiResult<PredictorModel> {
        return safeApiCall {
            val response = RetrofitInstance.api.getFixtures()
            if (response.isSuccessful) {
                ApiResult.Success(mapper.toDomain(response.body()!!))
            } else {
                ApiResult.GenericError(response.code(), response.message())
            }
        }
    }
}
