package com.si.fanalytics.match_predictor.framework.data.remote.service

import com.si.f1.library.framework.data.model.response.BaseResponseData
import com.si.fanalytics.match_predictor.framework.data.model.SubmitPredictionRequestE
import com.si.fanalytics.match_predictor.framework.data.model.fixture.FixtureE
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface PredictorService {

    @GET
    suspend fun getFixtures(
        @Url url: String
    ): BaseResponseData<List<FixtureE>>
    @POST
    suspend fun submitPrediction(
        @Url url: String,
        @Body submitPredictionRequest: SubmitPredictionRequestE
    ):BaseResponseData<Int>
}