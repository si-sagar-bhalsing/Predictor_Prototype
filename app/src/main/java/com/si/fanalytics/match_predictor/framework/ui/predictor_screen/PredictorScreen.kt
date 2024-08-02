package com.si.fanalytics.match_predictor.framework.ui.predictor_screen

import android.util.Log
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
import androidx.lifecycle.ViewModelProvider
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.si.fanalytics.match_predictor.ui.theme.Highlight
import com.si.fanalytics.match_predictor.ui.theme.PredictorScreenBg
import com.si.fanalytics.match_predictor.ui.theme.TextColor
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
//@Preview
@Composable
fun MatchDayScreen(modifier: Modifier,matchViewModel  : MatchViewModel = hiltViewModel()) {
    var data = dummyMatchDays
    var selectedTabIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState()

    // As rememberPagerState is not directly observable in the way LiveData or StateFlow is
    // We can use Compose state observation mechanisms like
    // snapshotFlow and LaunchedEffect to observe and react to changes in the PagerState.

    // This is a side effect that runs a coroutine whenever pagerState changes
    LaunchedEffect(pagerState) {
        // This creates a flow that emits the current page whenever it changes.
        snapshotFlow { pagerState.currentPage }.collect { page ->
            selectedTabIndex = page
        }

    }

    LaunchedEffect(Unit) {
        matchViewModel.getFixtures()
    }

    //val viewModel : MatchPredictorViewModel = hiltViewModel()
    val viewModel: MatchPredictorViewModel = remember {
        ViewModelProvider.NewInstanceFactory().create(MatchPredictorViewModel::class.java)
    }
    val isBottomSheetOpen by viewModel.isBottomSheetVisible



    Column(
        modifier = Modifier
            .background(color = PredictorScreenBg)
            .fillMaxSize()
    ) {
        val scope = rememberCoroutineScope()
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color(0xFF0B1E60),
            //containerColor = Color(0xFF0B1E60),
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
            data.forEachIndexed { index, matchDay ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(matchDay.matchDay) }
                )
            }
        }

        Text(
            text = data[selectedTabIndex].dateRange,
            color = TextColor,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        HorizontalPager(
            state = pagerState,
            count = data.size,
        ) { page ->
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(data[page].matches) { match ->
                    MatchInfoCard(match) { matchId ->
                        viewModel.setMatchId(matchId)
                        viewModel.showBottomSheet()
                        viewModel.setPage(page)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
    viewModel.getMatchById(viewModel.matchId.value)?.let { it ->
        BottomSheetLayout(
            isBottomSheetOpen = isBottomSheetOpen,
            onHideBottomSheet = { viewModel.hideBottomSheet() },
            onShowBottomSheet = { viewModel.showBottomSheet() },
            match = it,
            onIndexPass = {
                Log.d("index : ", it.toString())
                viewModel.setPredictHomeScore(it.first)
                viewModel.setPredictAwayScore(it.second)
                Log.d("predictHomeScore", viewModel.predictHomeScore.value.toString())
                Log.d("predictAwayScore", viewModel.predictAwayScore.value.toString())
            },
            onSaveClick = {

                Log.d("MatchId", "MainScreen_matchId :" + viewModel.matchId.value.toString())
                Log.d("MatchId", "MainScreen_PredictHomeScore :" + viewModel.predictHomeScore.value.toString())
                Log.d("MatchId", "MainScreen_PredictAwayScore :" + viewModel.predictAwayScore.value.toString())

                data[viewModel.currentPage.value].matches.find { viewModel.matchId.value == it.matchId }?.predictedHomeScore = 8
                //viewModel.matchPrediction.value.predictHomeScore
                //Log.d("MatchId", "MainScreen_value :" + value.toString())
                Log.d("predictHomeScore", dummyMatchDays[viewModel.currentPage.value].matches.find { viewModel.matchId.value == it.matchId }?.predictedHomeScore.toString())
                //it.predictedHomeScore = viewModel.matchPrediction.value.predictHomeScore
                //it.predictedAwayScore = viewModel.matchPrediction.value.predictAwayScore
            },
            content = {},

            )
    }
}