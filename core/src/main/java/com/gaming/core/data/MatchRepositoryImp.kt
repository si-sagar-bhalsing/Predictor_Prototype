package com.gaming.core.data

import android.util.Log
import com.gaming.core.data.ApiResult
import com.gaming.core.data.MatchRepository
import com.gaming.core.data.RetrofitInstance
import com.gaming.core.data.interactor.PredictorModelMapper
import com.gaming.core.data.model.PredictorModel
import com.gaming.core.data.safeApiCall

class MatchRepositoryImp(private val mapper: PredictorModelMapper) : MatchRepository {
    override suspend fun getFixtures(): ApiResult<PredictorModel> {
        return safeApiCall {
            val response = RetrofitInstance.api.getFixtures()
            if (response.isSuccessful) {
                Log.d("API Response", response.body().toString())
                ApiResult.Success(mapper.toDomain(response.body()!!))
            } else {
                ApiResult.GenericError(response.code(), response.message())
            }
        }
    }
}
