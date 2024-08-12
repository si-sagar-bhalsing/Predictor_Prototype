package com.si.fanalytics.predictor_core.business.data.utils


sealed class UseCaseResult<out D> {
    data class Success<D>(
        val data: D
    ) : UseCaseResult<D>()

    data class Failure(val throwable: Throwable) : UseCaseResult<Nothing>()
}