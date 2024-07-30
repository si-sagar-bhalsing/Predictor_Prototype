package com.si.fanalytics.match_predictor.data


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

internal suspend fun <T> safeApiCall(apiCall: suspend () -> ApiResult<T>): ApiResult<T> {
    val TAG = "safeApiCall"
    return withContext(Dispatchers.IO) {
        try {
            apiCall.invoke()
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            when (throwable) {
                is SocketTimeoutException -> {
                    ApiResult.NetworkError("Something went wrong!")
                }

                is UnknownHostException -> {
                    ApiResult.NetworkError("Something went wrong!")
                }

                is ConnectException -> {
                    ApiResult.NetworkError("You don't have a proper internet connection")
                }


                is IOException -> {
                    ApiResult.NetworkError("Something went wrong!")
                }

                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    ApiResult.GenericError(
                        code, errorResponse
                    )
                }

                else -> {
                    ApiResult.GenericError(null, "Something went wrong!")
                }
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): String? {
    return try {
        throwable.toString()
    } catch (exception: Exception) {
        "Unknown"
    }
}

sealed class ApiResult<out T> {

    data class Success<T>(val data: T) : ApiResult<T>()

    data class GenericError(val code: Int?, val message: String?) : ApiResult<Nothing>()

    data class NetworkError(val message: String?) : ApiResult<Nothing>()

    object NullDataError : ApiResult<Nothing>()
}
