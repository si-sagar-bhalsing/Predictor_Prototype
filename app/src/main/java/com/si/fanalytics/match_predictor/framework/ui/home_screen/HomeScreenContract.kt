package com.si.fanalytics.match_predictor.framework.ui.home_screen

import com.si.fanalytics.match_predictor.business.domain.model.Fixture
import com.si.fanalytics.match_predictor.framework.base.UiEffect
import com.si.fanalytics.match_predictor.framework.base.UiEvent
import com.si.fanalytics.match_predictor.framework.base.UiState

class HomeScreenContract {
    sealed class Event:UiEvent{

    }

    data class State(
        val isLoading:Boolean=false,
        val fixtures:List<Fixture> = listOf()
    ):UiState

    sealed class Effect:UiEffect{
        data class ShowToast(val message:String): Effect()
    }
}