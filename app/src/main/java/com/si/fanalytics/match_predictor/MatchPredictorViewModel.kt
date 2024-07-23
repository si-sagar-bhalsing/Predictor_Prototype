import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
class MatchPredictorViewModel: ViewModel() {
    private val _isBottomSheetVisible = mutableStateOf(false)
    val isBottomSheetVisible: State<Boolean> = _isBottomSheetVisible

    private val _matchPrediction = mutableStateOf(Prediction(0, 0))
    val matchPrediction: State<Prediction> = _matchPrediction

    fun showBottomSheet() {
        _isBottomSheetVisible.value = true
    }

    fun hideBottomSheet() {
        _isBottomSheetVisible.value = false
    }

    fun updatePrediction(predictHomeScore: Int?, predictAwayScore: Int?) {
        _matchPrediction.value = Prediction(predictHomeScore, predictAwayScore)
    }

    data class Prediction(val predictHomeScore: Int?, val predictAwayScore: Int?)

}
