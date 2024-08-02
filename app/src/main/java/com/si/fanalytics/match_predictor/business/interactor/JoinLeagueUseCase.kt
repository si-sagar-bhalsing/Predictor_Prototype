package com.si.fanalytics.match_predictor.business.interactor

import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.match_predictor.business.repository.PredictorRepository
import javax.inject.Inject

class JoinLeagueUseCase @Inject constructor(private val predictorRepository: PredictorRepository) {

    suspend fun invoke(request:JoinLeagueRequest):UseCaseResult<Int>{
        return  when(val result=predictorRepository.joinLeague(request=request)){
            is Resource.Success->{
                UseCaseResult.Success(data = result.data)
            }
            is Resource.Error->{
                UseCaseResult.Failure(throwable = result.throwable)
            }
        }
    }
}