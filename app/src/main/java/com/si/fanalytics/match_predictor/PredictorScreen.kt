package com.si.fanalytics.match_predictor

import MatchPredictorViewModel
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
import androidx.lifecycle.ViewModelProvider
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.si.fanalytics.match_predictor.ui.theme.Highlight
import com.si.fanalytics.match_predictor.ui.theme.PredictorScreenBg
import com.si.fanalytics.match_predictor.ui.theme.TextColor
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun MatchDayScreen(modifier: Modifier) {
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
            dummyMatchDays.forEachIndexed { index, matchDay ->
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
            text = dummyMatchDays[selectedTabIndex].dateRange,
            color = TextColor,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        HorizontalPager(
            state = pagerState,
            count = dummyMatchDays.size,
        ) { page ->
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(dummyMatchDays[page].matches) { match ->
                    MatchInfoCard(match, { matchId ->
                        viewModel.setMatchId(matchId)
                        viewModel.showBottomSheet()
                    })
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
    viewModel.getMatchById(viewModel.matchId.value)?.let {
        BottomSheetLayout(
            isBottomSheetOpen = isBottomSheetOpen,
            onHideBottomSheet = { viewModel.hideBottomSheet() },
            onShowBottomSheet = { viewModel.showBottomSheet() },
            match = it,
            onSaveClick = {
                match.predictedHomeScore = viewModel.matchPrediction.value.predictHomeScore
                match.predictedAwayScore = viewModel.matchPrediction.value.predictAwayScore
            },
            content = {}
        )
    }
}