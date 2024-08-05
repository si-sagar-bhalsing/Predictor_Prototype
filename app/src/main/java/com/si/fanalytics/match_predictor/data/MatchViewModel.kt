package com.si.fanalytics.match_predictor.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.si.fanalytics.match_predictor.data.ApiResult
import com.si.fanalytics.match_predictor.data.interactor.*
import com.si.fanalytics.match_predictor.data.model.PredictorModel
import com.si.fanalytics.match_predictor.data.model.Value
import com.si.fanalytics.match_predictor.data.repository.MatchRepositoryImp
import kotlinx.coroutines.launch

class MatchViewModel : ViewModel() {
    private val repository = MatchRepositoryImp(
        PredictorModelMapper(
            DataMapper(FeedTimeMapper(), ValueMapper(MatchQuestionMapper(OptionListsMapper()))),
            MetaMapper(TimestampMapper())
        )
    )

    private val _fixtures = MutableLiveData<PredictorModel?>()
    val fixtures: LiveData<PredictorModel?> get() = _fixtures

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    val matchdays = mutableStateOf<List<String>>(emptyList())

    fun getFixtures() {
        viewModelScope.launch {
            when (val result = repository.getFixtures()) {
                is ApiResult.Success -> {
                    _fixtures.postValue(result.data)
                    val uniqueMatchdays = getUniqueMatchdays(result.data.Data?.Value)
                    matchdays.value = uniqueMatchdays

                    Log.d("MatchViewModel", "API Data: ${result.data}")
                }

                is ApiResult.GenericError -> {
                    _error.postValue(result.message ?: "An error occurred")
                    Log.d("MatchViewModel", "API Error: ${result.message}")
                }

                is ApiResult.NetworkError -> {
                    _error.postValue(result.message ?: "A network error occurred")
                    Log.d("MatchViewModel", "Network Error: ${result.message}")
                }

                ApiResult.NullDataError -> {
                    _error.postValue("Received null data from the API")
                    Log.d("MatchViewModel", "Null Data Error")
                }
            }
        }
    }

    private fun getUniqueMatchdays(fixtures: List<Value>?): List<String> {
        fixtures?.forEach { value ->
            value.matchday?.let { Log.d("MatchDayValue", it) }
        }
        return fixtures?.mapNotNull { it.matchday }?.distinct() ?: emptyList()
    }

    fun getMatchesForMatchday(matchday: String): List<Value> {
        return _fixtures.value?.Data?.Value?.filter { it.matchday == matchday } ?: emptyList()
    }
}
