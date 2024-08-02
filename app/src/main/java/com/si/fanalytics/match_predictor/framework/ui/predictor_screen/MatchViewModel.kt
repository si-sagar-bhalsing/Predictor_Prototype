package com.si.fanalytics.match_predictor.framework.ui.predictor_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.si.fanalytics.match_predictor.business.domain.model.PredictorModel
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.interactor.GetFixturesUseCase
import com.si.fanalytics.match_predictor.business.interactor.SubmitPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MatchViewModel @Inject constructor(
    private val getFixturesUseCase: GetFixturesUseCase
) : ViewModel() {


    private val _fixtures = MutableLiveData<PredictorModel>()
    val fixtures: LiveData<PredictorModel> get() = _fixtures
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun getFixtures() {
        viewModelScope.launch {
            when (val result = getFixturesUseCase.invoke()) {
                is UseCaseResult.Success -> {
                    Log.d("TAG", "getFixtures: ${result.data}")
                   //_fixtures.postValue(result.data)

                }

                is UseCaseResult.Failure -> {
                    _error.postValue(result.throwable.toString())
                }
            }
        }
    }
companion object{
    const val TAG="MatchViewModel"
}
}