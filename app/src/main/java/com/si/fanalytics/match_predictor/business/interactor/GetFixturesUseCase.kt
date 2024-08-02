package com.si.fanalytics.match_predictor.business.interactor

import com.si.fanalytics.match_predictor.business.domain.model.Fixture
import com.si.fanalytics.match_predictor.business.data.utils.CustomThrowable
import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.repository.PredictorRepository
import javax.inject.Inject

class GetFixturesUseCase @Inject constructor(
    private val predictorRepository: PredictorRepository
){
    suspend  fun invoke():UseCaseResult<List<Fixture>>{
        return when(val resource=predictorRepository.getFixtures()){
            is Resource.Success->{
                UseCaseResult.Success(data= resource.data)
            }
            is Resource.Error->{
                UseCaseResult.Failure(CustomThrowable(message = "Something went wrong"))
            }
        }
    }
}