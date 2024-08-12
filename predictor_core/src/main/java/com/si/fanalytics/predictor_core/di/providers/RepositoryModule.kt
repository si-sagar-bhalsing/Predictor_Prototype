package com.si.fanalytics.predictor_core.di.providers

import com.si.fanalytics.predictor_core.business.repository.PredictorRepository
import com.si.fanalytics.predictor_core.framework.data.repository.PredictorRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun providesPredictorRepository(predictorRepositoryImpl: PredictorRepositoryImpl): PredictorRepository
}