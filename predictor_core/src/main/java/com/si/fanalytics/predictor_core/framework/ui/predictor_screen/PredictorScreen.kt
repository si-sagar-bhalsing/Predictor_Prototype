package com.si.fanalytics.predictor_core.framework.ui.predictor_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.si.fanalytics.predictor_core.business.domain.model.SubmitPredictionRequest
import com.si.fanalytics.predictor_core.business.domain.model.requests.ApplyBoosterRequest
import com.si.fanalytics.predictor_core.framework.ui.home_screen.HomeScreenContract
import com.si.fanalytics.predictor_core.framework.ui.home_screen.HomeScreenViewModel
import com.si.fanalytics.predictor_core.ui.theme.Highlight
import com.si.fanalytics.predictor_core.ui.theme.PredictorScreenBg
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun MatchDayScreen(
    modifier: Modifier,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    matchPredictorViewModel: MatchPredictorViewModel = hiltViewModel()
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState()

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            selectedTabIndex = page
        }
    }

    val isBottomSheetOpen by matchPredictorViewModel.isBottomSheetVisible
    val state by homeScreenViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .background(color = PredictorScreenBg)
            .fillMaxSize()
    ) {
        val scope = rememberCoroutineScope()
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color(0xFF0B1E60),
            contentColor = Color.White,
            edgePadding = 16.dp,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    color = Highlight
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            state.matchdays.forEachIndexed { index, matchDay ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text("Match Day " + matchDay.toString()) }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            count = state.fixtures.size,
        ) { page ->
            val matchesForMatchday = homeScreenViewModel.getMatchesForMatchday((page + 1).toString())
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(matchesForMatchday) { match ->
                    MatchInfoCard(match, onClick = { matchId ->
                        matchPredictorViewModel.setMatchId(matchId)
                        matchPredictorViewModel.showBottomSheet()
                        matchPredictorViewModel.setPage(page)
                    }, onBoosterClick = {
                        val boosterApplyRequest = ApplyBoosterRequest(
                            optType = 1,
                        tourId =  1,
                        soccerMatchId = "3jpenyzsv80vq8cjvur2836z8",
                        tourGameDayId = 1,
                        boosterId = 1
                        )
                        homeScreenViewModel.handleEvent(HomeScreenContract.Event.ApplyBooster(boosterApplyRequest))

                    }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

        }
    }


    homeScreenViewModel.getMatchById(matchPredictorViewModel.matchId.value)?.let { it ->
        BottomSheetLayout(
            isBottomSheetOpen = isBottomSheetOpen,
            onHideBottomSheet = { matchPredictorViewModel.hideBottomSheet() },
            onShowBottomSheet = { matchPredictorViewModel.showBottomSheet() },
            match = it,
            onIndexPass = { (homeScore, awayScore) ->
                matchPredictorViewModel.setPredictHomeScore(homeScore)
                matchPredictorViewModel.setPredictAwayScore(awayScore)
            },
            onSaveClick = {
                // Create a SubmitPredictionRequest object
                val submitPredictionRequest = SubmitPredictionRequest(
                    soccerMatchId = "3jaxaba41eo1xj0esrt73nnkk",
                    tourGameDayId = 1,
                    tourId = 1,
                    arrTeamId = listOf("c9swyor08g9pedxpe3n321svu", "7wiwxjo7a9yudfe72ls12i4q5"),
                    boosterId = 0,
                    questionId = 1,
                    betCoin = 1,
                    optionId = 1,
                )
                homeScreenViewModel.handleEvent(HomeScreenContract.Event.SubmitPrediction(submitPredictionRequest))
            },
            content = {}
        )
    }
}
