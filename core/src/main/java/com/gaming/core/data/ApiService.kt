package com.gaming.core.data

import com.gaming.core.data.interactor.PredictorModelE
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("predictor/feeds/fixtures/fixtures_1_en.json")
    suspend fun getFixtures(): Response<PredictorModelE>
}
