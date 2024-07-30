package com.si.fanalytics.match_predictor.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.si.fanalytics.match_predictor.data.model.PredictorModel
import com.si.fanalytics.match_predictor.data.repository.MatchRepositoryImp
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class MatchViewModel : ViewModel() {
    private val repository = MatchRepositoryImp()
    private val _fixtures = MutableLiveData<PredictorModel>()
    val fixtures: LiveData<PredictorModel> get() = _fixtures
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun getFixtures() {
        viewModelScope.launch {
            when (val result = repository.getFixtures()) {
                is ApiResult.Success -> {
                    _fixtures.postValue(result.data)
                    Log.d("MatchViewModel", "API Data: ${result.data}")

                }
                is ApiResult.GenericError -> {
                    _error.postValue(result.message ?: "An error occurred")
                }
                is ApiResult.NetworkError -> {
                    _error.postValue(result.message ?: "A network error occurred")
                }
                ApiResult.NullDataError -> {
                    _error.postValue("Received null data from the API")
                }
            }
        }
    }
}
