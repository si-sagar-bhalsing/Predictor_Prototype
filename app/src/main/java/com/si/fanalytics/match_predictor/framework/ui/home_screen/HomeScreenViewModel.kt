package com.si.fanalytics.match_predictor.framework.ui.home_screen

import android.util.Log
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.si.fanalytics.match_predictor.business.data.utils.UseCaseResult
import com.si.fanalytics.match_predictor.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.CreateLeagueRequest
import com.si.fanalytics.match_predictor.business.domain.model.requests.JoinLeagueRequest
import com.si.fanalytics.match_predictor.business.domain.model.response.Fixture
import com.si.fanalytics.match_predictor.business.interactor.ApplyBoosterUseCase
import com.si.fanalytics.match_predictor.business.interactor.CreateLeagueUseCase
import com.si.fanalytics.match_predictor.business.interactor.GetFixturesUseCase
import com.si.fanalytics.match_predictor.business.interactor.GetUserPredictionsUseCase
import com.si.fanalytics.match_predictor.business.interactor.JoinLeagueUseCase
import com.si.fanalytics.match_predictor.business.interactor.SubmitPredictionUseCase
import com.si.fanalytics.match_predictor.framework.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale.filter
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val fixturesUseCase: GetFixturesUseCase,
    private val submitPredictionUseCase: SubmitPredictionUseCase,
    private val applyBoosterUseCase: ApplyBoosterUseCase,
    private val getUserPredictionsUseCase: GetUserPredictionsUseCase,
    private val createLeagueUseCase: CreateLeagueUseCase,
    private val joinLeagueUseCase: JoinLeagueUseCase
) :
    BaseViewModel<HomeScreenContract.Event, HomeScreenContract.State, HomeScreenContract.Effect>() {
    override fun createInitialState() = HomeScreenContract.State()

    override fun handleEvent(event: HomeScreenContract.Event) {
        when (event) {
            is HomeScreenContract.Event.SubmitPrediction -> {
                submitPrediction(event.prediction)
            }
            // Handle other events here
        }
    }

    private val fixtures = MutableLiveData<List<Fixture>>()

    fun getMatchById(id: Int?): Fixture? {
        fixtures.value?.forEach { fixtures ->
            if (fixtures.matchId == id.toString()) {
                return fixtures
            }
        }
        return null
    }

    fun calculateMatchdays(): List<String> {
        return fixtures.value?.mapNotNull { it.matchday }?.distinct() ?: emptyList()

    }

    init {
        getFixtures()
        //submitPrediction()
        //applyBooster()
        // getUserPredictions()
        //createLeague()
        //joinLeague()
    }

    fun getMatchesForMatchday(matchday: String): List<Fixture> {
        return fixtures.value.orEmpty().filter { it.matchday == matchday }
    }

    fun getFixtures() {
        viewModelScope.launch {
            when (val result = fixturesUseCase.invoke()) {
                is UseCaseResult.Success -> {
                    Log.d(TAG, "getFixtures: Success ${result.data}")
                    fixtures.value = result.data
                    setState {
                        copy(
                            fixtures = result.data,
                            matchdays = calculateMatchdays()
                        )
                    }
                }

                is UseCaseResult.Failure -> {
                    Log.d(TAG, "getFixtures: failed ${result.throwable}")

                }
            }
        }
    }

    fun submitPrediction(predictionRequest: SubmitPredictionRequest) {
        viewModelScope.launch {
            when (val result = submitPredictionUseCase.invoke(
                predictionRequest
            )) {
                is UseCaseResult.Success -> {
                }

                is UseCaseResult.Failure -> {
                }
            }
        }
    }

    fun applyBooster() {
        viewModelScope.launch {
            val result = applyBoosterUseCase.invoke(
                ApplyBoosterRequest(
                    boosterId = 1,
                    tourGameDayId = 1,
                    soccerMatchId = "43jaahbvhozemngcub81d9f6c",
                    tourId = 1,
                    optType = 1
                )
            )
            when (result) {
                is UseCaseResult.Success -> {
                    Log.d(TAG, "applyBooster: Success")
                }

                is UseCaseResult.Failure -> {
                    Log.d(TAG, "applyBooster: Failure")
                }
            }
        }
    }

    fun getUserPredictions() {
        viewModelScope.launch {
            when (val result = getUserPredictionsUseCase.invoke()) {
                is UseCaseResult.Success -> {
                    Log.d(TAG, "getUserPredictions: ${result.data}")
                }

                is UseCaseResult.Failure -> {
                    Log.d(TAG, "getUserPredictions: ${result.throwable}")
                }
            }
        }
    }

    fun createLeague() {
        viewModelScope.launch {
            val result = createLeagueUseCase.invoke(
                request = CreateLeagueRequest(
                    leagueName = "Legaue of leagues",
                    leagueCode = 11,
                    gamedayId = 1,
                    optType = 1,
                    leagueId = 0,
                    tourId = 1
                )
            )
            when (result) {
                is UseCaseResult.Success -> {
                    Log.d(TAG, "createLeague: Success ${result.data}")
                }

                is UseCaseResult.Failure -> {
                    Log.d(TAG, "createLeague: failure ${result.throwable}")
                }
            }
        }
    }

    fun joinLeague() {
        viewModelScope.launch {
            val result = joinLeagueUseCase.invoke(
                request = JoinLeagueRequest(
                    optType = 1,
                    gamedayId = 1,
                    leagueId = 0,
                    leagueCode = 242,
                    leagueName = "Legaue of leagues",
                    tourId = 1
                )
            )
            when (result) {
                is UseCaseResult.Success -> {
                    Log.d(TAG, "joinLeague: Success ${result.data}")
                }

                is UseCaseResult.Failure -> {
                    Log.d(TAG, "joinLeague: failure ${result.throwable}")
                }
            }
        }
    }

    companion object {
        const val TAG = "HOME SCREEN"
    }
}