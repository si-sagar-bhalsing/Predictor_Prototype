package com.si.fanalytics.predictor_core.business.interactor

import com.si.fanalytics.predictor_core.business.data.utils.Resource
import com.si.fanalytics.predictor_core.business.data.utils.UseCaseResult
import com.si.fanalytics.predictor_core.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.predictor_core.business.repository.PredictorRepository
import javax.inject.Inject

class ApplyBoosterUseCase @Inject constructor(
    private val predictorRepository: PredictorRepository
) {
    suspend fun invoke(request: ApplyBoosterRequest): UseCaseResult<Int> {
        return when(val result=predictorRepository.applyBooster(request=request)){
            is Resource.Success->{
               UseCaseResult.Success(data = result.data)
            }
            is Resource.Error ->{
                UseCaseResult.Failure(throwable = result.throwable)
            }
        }
    }
}