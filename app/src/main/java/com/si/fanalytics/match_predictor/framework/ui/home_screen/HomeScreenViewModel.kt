package com.si.fanalytics.match_predictor.framework.ui.home_screen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.interactor.GetFixturesUseCase
import com.si.fanalytics.match_predictor.business.interactor.SubmitPredictionUseCase
import com.si.fanalytics.match_predictor.framework.base.BaseViewModel
import com.si.fanalytics.match_predictor.framework.ui.predictor_screen.MatchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val fixturesUseCase: GetFixturesUseCase,
    private val submitPredictionUseCase: SubmitPredictionUseCase
) :
    BaseViewModel<HomeScreenContract.Event, HomeScreenContract.State, HomeScreenContract.Effect>() {
    override fun createInitialState()= HomeScreenContract.State()

    override fun handleEvent(event: HomeScreenContract.Event) {
      //  TODO("Not yet implemented")
    }

    init {
        getFixtures()
        //submitPrediction()
    }


    fun getFixtures(){
        viewModelScope.launch {
            when(val result=fixturesUseCase.invoke()){
               is UseCaseResult.Success->{
                   Log.d(TAG, "getFixtures: Success ${result.data}")
                   setState {
                       copy(
                           fixtures=result.data
                       )
                   }
                }
               is UseCaseResult.Failure->{
                   Log.d(TAG, "getFixtures: failed ${result.throwable}")

               }
            }
        }
    }

    fun submitPrediction(){
        viewModelScope.launch {
            when(val result=submitPredictionUseCase.invoke(
                SubmitPredictionRequest(
                soccerMatchId = "3jaxaba41eo1xj0esrt73nnkk",
                tourGameDayId =1 ,
                tourId = 1,
                arrTeamId = listOf("c9swyor08g9pedxpe3n321svu","7wiwxjo7a9yudfe72ls12i4q5"),
                boosterId =0 ,
                questionId =1,
                betCoin =1 ,
                optionId = 1,
            )
            )){
                is UseCaseResult.Success->{
                    Log.d(MatchViewModel.TAG, ":submitPredictionUseCase result ${result.data}")
                }
                is UseCaseResult.Failure->{
                    Log.d(MatchViewModel.TAG, ":submitPredictionUseCase result failed ${result.throwable}")
                }
            }
        }
    }

    companion object {
        const val TAG="HOME SCREEN"
    }
}