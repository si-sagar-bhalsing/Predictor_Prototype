package com.si.fanalytics.match_predictor.business.data.utils


sealed class UseCaseResult<out D> {
    data class Success<D>(
        val data: D
    ) : UseCaseResult<D>()

    data class Failure(val throwable: Throwable) : UseCaseResult<Nothing>()
}