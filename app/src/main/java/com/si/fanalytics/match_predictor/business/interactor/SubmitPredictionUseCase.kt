package com.si.fanalytics.match_predictor.business.interactor

import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.repository.PredictorRepository
import javax.inject.Inject

class SubmitPredictionUseCase @Inject constructor(
    private val predictorRepository: PredictorRepository
) {
    suspend fun invoke(submitPredictionRequest: SubmitPredictionRequest):UseCaseResult<Int>{
        return when(val resource=predictorRepository.submitPrediction(submitPredictionRequest)){
            is Resource.Success ->{
               UseCaseResult.Success(data = resource.data)
            }
            is Resource.Error->{
                UseCaseResult.Success(data = 0)
            }
        }
    }
}