@file:OptIn(ExperimentalFoundationApi::class)

package com.gaming.core.presentation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.gaming.core.data.MatchViewModel
import com.gaming.core.ui.theme.Highlight
import com.gaming.core.ui.theme.PredictorScreenBg
import com.gaming.core.ui.theme.TextColor
import kotlinx.coroutines.launch


//@Preview
@Composable
fun MatchDayScreen(modifier: Modifier) {
    var data = dummyMatchDays
    var selectedTabIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState(
        pageCount = {
            data.size
        })
    val matchViewModel = remember {
        ViewModelProvider.NewInstanceFactory().create(MatchViewModel::class.java)
    }
    val fixtures = matchViewModel.fixtures.observeAsState()
    val error = matchViewModel.error.observeAsState()

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
    val mactchdays = matchViewModel.matchdays.value
    Log.d("MatchDays", mactchdays.toString())


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
            contentColor = Color.White,
            edgePadding = 16.dp,
            indicator = { tabPositions ->
                if (tabPositions.isNotEmpty())
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
//                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                        color = Highlight
                    )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            val tabs = mutableSetOf<String?>()

            fixtures.value?.Data?.Value?.map {
                tabs.add(it.matchday.toString())
                Log.d("FIXTURES_DATA", it.matchday.toString())
            }
            tabs.forEachIndexed { index, matchDay ->
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

        Text(
            text = data[selectedTabIndex].dateRange,
            color = TextColor,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )

        HorizontalPager(
            state = pagerState,
        ) { page ->
            val matchesForMatchday = matchViewModel.getMatchesForMatchday((page + 1).toString())
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(matchesForMatchday) { match ->
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
            },
            onSaveClick = {
            },
            content = {},

            )
    }
}