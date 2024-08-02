package com.si.fanalytics.match_predictor.framework.data.remote.service

import com.si.fanalytics.match_predictor.framework.data.model.response.BaseResponseData
import com.si.fanalytics.match_predictor.framework.data.model.SubmitPredictionRequestE
import com.si.fanalytics.match_predictor.framework.data.model.fixture.FixtureE
import com.si.fanalytics.match_predictor.framework.data.model.ApplyBoosterRequestE
import com.si.fanalytics.match_predictor.framework.data.model.UserPredictionsE
import com.si.fanalytics.match_predictor.framework.data.model.response.BaseResponse
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
    ): BaseResponseData<Int>

    @POST
    suspend fun applyBooster(
        @Url url: String,
        @Body applyBoosterRequest: ApplyBoosterRequestE
    ): BaseResponseData<Int>

    @GET
    suspend fun getUserPredictions(
        @Url url: String
    ): BaseResponse<UserPredictionsE>
}