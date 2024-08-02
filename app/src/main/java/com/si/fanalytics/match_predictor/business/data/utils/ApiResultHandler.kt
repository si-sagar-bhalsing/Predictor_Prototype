package com.si.fanalytics.match_predictor.business.data.utils

import com.si.fanalytics.match_predictor.business.data.ApiResult


internal abstract class ApiResultHandler<Result, Data>(
    private val response: ApiResult<Result?>,
) {

    suspend fun getResult(): Resource<Data> {


        return when (response) {
            is ApiResult.GenericError -> {
                Resource.Error(throwable = CustomThrowable(response.code, "Some thing Went Wrong"))
            }

            is ApiResult.NetworkError -> {
                Resource.Error(throwable = CustomThrowable(null, response.message ?: ""))
            }

            is ApiResult.Success -> {
                if (response.data == null) {
                    Resource.Error(throwable = CustomThrowable(null, "No response from api"))
                } else {
                    handleSuccess(resultObj = response.data)
                }
            }
            is ApiResult.NullDataError -> {
                Resource.Error(throwable = CustomThrowable(404, "Data not found"))
            }
        }
    }

    abstract suspend fun handleSuccess(resultObj: Result): Resource<Data>

}