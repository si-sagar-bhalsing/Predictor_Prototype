package com.si.fanalytics.predictor_core.business.interactor

import com.si.fanalytics.predictor_core.business.data.utils.Resource
import com.si.fanalytics.predictor_core.business.data.utils.UseCaseResult
import com.si.fanalytics.predictor_core.business.domain.model.response.Prediction
import com.si.fanalytics.predictor_core.business.repository.PredictorRepository
import javax.inject.Inject

class GetUserPredictionsUseCase @Inject constructor(private val predictorRepository: PredictorRepository) {

    suspend fun invoke(): UseCaseResult<Prediction> {
        val result=predictorRepository.getUserPredictions()
        return when(result){
            is Resource.Success ->{
               UseCaseResult.Success(data = result.data)
            }
            is Resource.Error ->{
                UseCaseResult.Failure(throwable = result.throwable)
            }
        }
    }
}