package com.si.fanalytics.match_predictor.di.providers

import com.si.fanalytics.match_predictor.business.data.network.PredictorNetworkDataSource
import com.si.fanalytics.match_predictor.framework.data.remote.datasource_impl.PredictorNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkDataSourceModule {

    @Binds
    fun providePredictorNetworkDataSource(predictorNetworkDataSourceImpl: PredictorNetworkDataSourceImpl):PredictorNetworkDataSource
}