package com.si.fanalytics.predictor_core.business.interactor

import com.si.fanalytics.predictor_core.business.data.utils.CustomThrowable
import com.si.fanalytics.predictor_core.business.data.utils.Resource
import com.si.fanalytics.predictor_core.business.data.utils.UseCaseResult
import com.si.fanalytics.predictor_core.business.domain.model.response.Fixture
import com.si.fanalytics.predictor_core.business.repository.PredictorRepository
import javax.inject.Inject

class GetFixturesUseCase @Inject constructor(
    private val predictorRepository: PredictorRepository
){
    suspend  fun invoke(): UseCaseResult<List<Fixture>> {
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