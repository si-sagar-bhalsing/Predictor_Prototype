package com.si.fanalytics.match_predictor.business.data.utils

import okhttp3.Interceptor
import okhttp3.Response

class CustomRequestInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {

        val builder = chain.request().newBuilder()

        builder.addHeader("entity", "d3tR0!t5m@sh")
        builder.addHeader("referer", "https://www.afc.staging.digitalservices.sportradar.com/")


        return chain.proceed(builder.build())
    }
}