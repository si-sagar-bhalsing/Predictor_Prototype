package com.si.fanalytics.match_predictor.framework.ui.predictor_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MatchPredictorViewModel : ViewModel() {
    private val _isBottomSheetVisible = mutableStateOf(false)
    val isBottomSheetVisible: State<Boolean> = _isBottomSheetVisible

    private val _matchPrediction = mutableStateOf(Prediction(null, null))
    val matchPrediction: State<Prediction> = _matchPrediction

    private val _matchId = mutableStateOf<Int?>(null)
    val matchId: State<Int?> = _matchId

    private val _currentPage = mutableStateOf<Int>(0)
    val currentPage: State<Int> = _currentPage

    private val _predictHomeScore = mutableStateOf<Int?>(null)
    val predictHomeScore: State<Int?> = _predictHomeScore

    private val _predictAwayScore = mutableStateOf<Int?>(null)
    val predictAwayScore: State<Int?> = _predictAwayScore

    //val predictHomeScore = MutableLiveData<Int?>(null)
    //val predictAwayScore = MutableLiveData<Int?>(null)

    fun setPredictHomeScore(score: Int?) {
        _predictHomeScore.value = score
        Log.d("MatchId", "viewModelpredictHomeScore " + predictHomeScore.value)

    }

    fun setPredictAwayScore(score: Int?) {
        _predictAwayScore.value = score
    }

    fun showBottomSheet() {
        _isBottomSheetVisible.value = true
    }

    fun hideBottomSheet() {
        _isBottomSheetVisible.value = false
    }

    fun updatePrediction(predictHomeScore: Int?, predictAwayScore: Int?) {
        _matchPrediction.value = Prediction(predictHomeScore, predictAwayScore)
        Log.d("MatchPredictorViewModel", "Match Prediction updated: ${matchPrediction.value}")

    }

    fun setMatchId(id: Int) {
        _matchId.value = id
        Log.d("MatchPredictorViewModel", "Match data updated: ${matchId.value}")
    }

    fun setPage(page: Int) {
        _currentPage.value = page
    }

    fun savePrediction() {
        // Implement your logic to save the prediction using _matchId and _matchPrediction
        val currentMatchId = _matchId.value
        val prediction = _matchPrediction.value

        // Example API call or data update
        // updateMatchPrediction(currentMatchId, prediction)

        // Reset the values after saving
        _matchId.value = null
        _matchPrediction.value = Prediction(null, null)
    }



    data class Prediction(val predictHomeScore: Int?, val predictAwayScore: Int?)
}
