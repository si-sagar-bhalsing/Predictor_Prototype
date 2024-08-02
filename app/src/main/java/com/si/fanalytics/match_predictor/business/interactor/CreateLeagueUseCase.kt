package com.si.fanalytics.match_predictor.business.interactor

import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.match_predictor.business.repository.PredictorRepository
import javax.inject.Inject

class CreateLeagueUseCase @Inject constructor(
    private val predictorRepository: PredictorRepository
) {
    suspend fun invoke(request: CreateLeagueRequest):UseCaseResult<Int>{
        return  when(val result=predictorRepository.createLeague(request = request)){
            is Resource.Success->{
                UseCaseResult.Success(data = result.data)
            }
            is Resource.Error ->{
                UseCaseResult.Failure(throwable = result.throwable)
            }
        }
    }
}