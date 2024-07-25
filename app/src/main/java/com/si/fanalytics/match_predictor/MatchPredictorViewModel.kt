import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.si.fanalytics.match_predictor.Match
import com.si.fanalytics.match_predictor.dummyMatchDays
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MatchPredictorViewModel : ViewModel() {
    private val _isBottomSheetVisible = mutableStateOf(false)
    val isBottomSheetVisible: State<Boolean> = _isBottomSheetVisible

    private val _matchPrediction = mutableStateOf(Prediction(null, null))
    val matchPrediction: State<Prediction> = _matchPrediction

    private val _matchId = mutableStateOf<Int?>(null)
    val matchId: State<Int?> = _matchId

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
    fun getMatchById(id: Int?): Match? {
        for (matchDay in dummyMatchDays) {
            for (match in matchDay.matches) {
                if (match.matchId == id) {
                    return match
                }
            }
        }
        return null
    }
    data class Prediction(val predictHomeScore: Int?, val predictAwayScore: Int?)
}
