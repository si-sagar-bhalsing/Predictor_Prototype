package com.si.fanalytics.match_predictor.di.providers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.si.fanalytics.match_predictor.business.data.utils.CustomRequestInterceptor
import com.si.fanalytics.match_predictor.framework.data.remote.service.PredictorService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val BASE_URL = "https://stg-games.the-afc.com/"

    @Provides
    @Singleton
    fun provideOkHttp(

    ):OkHttpClient.Builder {
        return OkHttpClient.Builder()
            //Add interceptors here
            .addNetworkInterceptor(interceptor = CustomRequestInterceptor())
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
    }
    @Singleton
    @Provides
    internal fun providesGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        httpClient: OkHttpClient.Builder
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun providesPredictorService(retrofit: Retrofit):PredictorService{
        return retrofit.create(PredictorService::class.java)
    }

}