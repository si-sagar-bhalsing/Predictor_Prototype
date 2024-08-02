package com.si.fanalytics.match_predictor.di.providers

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.si.fanalytics.match_predictor.business.data.utils.CurlLoggingInterceptor
import com.si.fanalytics.match_predictor.business.data.utils.CustomRequestInterceptor
import com.si.fanalytics.match_predictor.framework.data.remote.TextConstant.BASE_URL
import com.si.fanalytics.match_predictor.framework.data.remote.service.PredictorService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttp(
        curlLoggingInterceptor: CurlLoggingInterceptor,
        customRequestInterceptor: CustomRequestInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ):OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor = customRequestInterceptor)
            .addNetworkInterceptor(interceptor = curlLoggingInterceptor)
            .addNetworkInterceptor(interceptor = httpLoggingInterceptor)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
    }

    @Singleton
    @Provides
    fun providesCustomInterceptor():CustomRequestInterceptor{
        return CustomRequestInterceptor()
    }
    @Singleton
    @Provides
    fun providesCurlInterceptor(): CurlLoggingInterceptor {
        return CurlLoggingInterceptor("cURL")
    }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
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