package com.si.fanalytics.match_predictor.framework.data.repository

import com.si.fanalytics.match_predictor.business.domain.model.Fixture
import com.si.fanalytics.match_predictor.business.data.network.PredictorNetworkDataSource
import com.si.fanalytics.match_predictor.business.data.utils.ApiResultHandler
import com.si.fanalytics.match_predictor.business.data.utils.Resource
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.repository.PredictorRepository
import javax.inject.Inject

class PredictorRepositoryImpl @Inject constructor(
    private val predictorNetworkDataSource: PredictorNetworkDataSource
) :PredictorRepository {
    override suspend fun getFixtures(): Resource<List<Fixture>> {
        val  result=predictorNetworkDataSource.getFixtures()

        val resource= object : ApiResultHandler<List<Fixture>, List<Fixture>>(result) {
            override suspend fun handleSuccess(resultObj: List<Fixture>): Resource<List<Fixture>> {
                return Resource.Success(resultObj)
            }
        }.getResult()
        
        return resource
    }

    override suspend fun submitPrediction(submitPredictionRequest: SubmitPredictionRequest): Resource<Int> {
        val result = predictorNetworkDataSource.submitPrediction(submitPredictionRequest)

        val resource=object :ApiResultHandler<Int,Int>(result){
            override suspend fun handleSuccess(resultObj: Int): Resource<Int> {
                return Resource.Success(resultObj)
            }
        }.getResult()

        return resource
    }
}
