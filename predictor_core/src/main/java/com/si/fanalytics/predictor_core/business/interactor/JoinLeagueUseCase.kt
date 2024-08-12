package com.si.fanalytics.predictor_core.business.interactor

import com.si.fanalytics.predictor_core.business.data.utils.Resource
import com.si.fanalytics.predictor_core.business.data.utils.UseCaseResult
import com.si.fanalytics.predictor_core.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.predictor_core.business.repository.PredictorRepository
import com.si.fanalytics.predictor_core.framework.data.model.leagues.response.LeagueResponse
import javax.inject.Inject

class JoinLeagueUseCase @Inject constructor(private val predictorRepository: PredictorRepository) {

    suspend fun invoke(request: JoinLeagueRequest): UseCaseResult<LeagueResponse> {
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