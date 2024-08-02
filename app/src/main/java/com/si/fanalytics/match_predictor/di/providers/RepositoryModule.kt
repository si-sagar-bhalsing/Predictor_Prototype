package com.si.fanalytics.match_predictor.di.providers

import com.si.fanalytics.match_predictor.business.repository.PredictorRepository
import com.si.fanalytics.match_predictor.framework.data.repository.PredictorRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun providesPredictorRepository(predictorRepositoryImpl: PredictorRepositoryImpl):PredictorRepository
}