package com.si.fanalytics.predictor_core.framework.ui.home_screen

import com.si.fanalytics.predictor_core.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.predictor_core.business.domain.model.response.Fixture
import com.si.fanalytics.predictor_core.framework.base.UiEffect
import com.si.fanalytics.predictor_core.framework.base.UiEvent
import com.si.fanalytics.predictor_core.framework.base.UiState

class HomeScreenContract {
    sealed class Event: UiEvent {
        data class SubmitPrediction(val prediction: SubmitPredictionRequest) : Event()

    }

    data class State(
        val isLoading:Boolean=false,
        val fixtures:List<Fixture> = listOf(),
        val matchdays:List<String> = listOf()
    ): UiState

    sealed class Effect: UiEffect {
        data class ShowToast(val message:String): Effect()
    }
}