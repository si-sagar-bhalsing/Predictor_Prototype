package com.si.fanalytics.match_predictor.business.interactor

import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.domain.model.Prediction
import com.si.fanalytics.match_predictor.business.repository.PredictorRepository
import javax.inject.Inject

class GetUserPredictionsUseCase @Inject constructor(private val predictorRepository: PredictorRepository) {

    suspend fun invoke():UseCaseResult<Prediction>{
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