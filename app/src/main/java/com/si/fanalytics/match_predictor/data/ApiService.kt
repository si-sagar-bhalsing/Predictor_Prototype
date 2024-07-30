package com.si.fanalytics.match_predictor.data

import com.si.fanalytics.match_predictor.data.model.PredictorModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("predictor/feeds/fixtures/fixtures_1_en.json")
    suspend fun getFixtures(): Response<PredictorModel>
}
