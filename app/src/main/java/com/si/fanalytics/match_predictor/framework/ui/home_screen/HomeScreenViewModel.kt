package com.si.fanalytics.match_predictor.framework.ui.home_screen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.domain.model.Requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.interactor.ApplyBoosterUseCase
import com.si.fanalytics.match_predictor.business.interactor.GetFixturesUseCase
import com.si.fanalytics.match_predictor.business.interactor.GetUserPredictionsUseCase
import com.si.fanalytics.match_predictor.business.interactor.SubmitPredictionUseCase
import com.si.fanalytics.match_predictor.framework.base.BaseViewModel
import com.si.fanalytics.match_predictor.framework.ui.predictor_screen.MatchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val fixturesUseCase: GetFixturesUseCase,
    private val submitPredictionUseCase: SubmitPredictionUseCase,
    private val applyBoosterUseCase: ApplyBoosterUseCase,
    private val getUserPredictionsUseCase: GetUserPredictionsUseCase
) :
    BaseViewModel<HomeScreenContract.Event, HomeScreenContract.State, HomeScreenContract.Effect>() {
    override fun createInitialState()= HomeScreenContract.State()

    override fun handleEvent(event: HomeScreenContract.Event) {
      //  TODO("Not yet implemented")
    }

    init {
        //getFixtures()
        //submitPrediction()
        //applyBooster()
        getUserPredictions()
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

    fun applyBooster(){
        viewModelScope.launch {
            val result=applyBoosterUseCase.invoke(
                ApplyBoosterRequest(
                    boosterId = 1,
                    tourGameDayId = 1,
                    soccerMatchId = "43jaahbvhozemngcub81d9f6c",
                    tourId = 1,
                    optType = 1
                )
            )
            when(result){
                is UseCaseResult.Success->{
                    Log.d(TAG, "applyBooster: Success")
                }
                is UseCaseResult.Failure->{
                    Log.d(TAG, "applyBooster: Failure")
                }
            }
        }
    }

    fun getUserPredictions(){
        viewModelScope.launch {
            when(val result=getUserPredictionsUseCase.invoke()){
                is UseCaseResult.Success->{
                    Log.d(TAG, "getUserPredictions: ${result.data}")
                }
                is UseCaseResult.Failure->{
                    Log.d(TAG, "getUserPredictions: ${result.throwable}")
                }
            }
        }
    }
    companion object {
        const val TAG="HOME SCREEN"
    }
}