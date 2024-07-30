package com.si.fanalytics.match_predictor

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.si.fanalytics.match_predictor.ui.theme.Highlight
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetLayout(
    isBottomSheetOpen: Boolean,
    onHideBottomSheet: () -> Unit,
    onShowBottomSheet: () -> Unit,
    match: Match,
    content: @Composable () -> Unit,
    onSaveClick: () -> Unit,
    onIndexPass: (Pair<Int, Int>) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember { mutableStateOf(Pair(0, 0)) }  // Manage selected index state
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Expanded,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = false
    )

    LaunchedEffect(isBottomSheetOpen) {
        coroutineScope.launch {
            if (isBottomSheetOpen) {
                modalSheetState.show()
            } else {
                modalSheetState.hide()
            }
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetContent = {
            BottomSheetContent(
                modalSheetState = modalSheetState,
                onHide = onHideBottomSheet,
                match = match,
                onSaveClick = onSaveClick,
                onIndexPass = {
                    selectedIndex = selectedIndex.copy(first = it.first)
                    selectedIndex = selectedIndex.copy(second = it.second)
                    onIndexPass(selectedIndex)
                }
            )
        }
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetContent(
    modalSheetState: ModalBottomSheetState,
    onHide: () -> Unit,
    match: Match,
    onSaveClick: () -> Unit,
    onIndexPass :(Pair<Int,Int>) -> Unit,

    ) {

    var selectedIndex by remember { mutableStateOf(Pair(0, 0)) }  // Manage selected index state
    var selectedHomeIndex by remember { mutableStateOf(0) }
    var selectedAwayIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .background(color = Color(0xFF0B1E60))
            .padding(16.dp)
    ) {
        IconButton(
            onClick = onHide,
            modifier = Modifier
                .align(Alignment.End)
                .size(20.dp)
                .align(Alignment.End),

            ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Close",
                tint = White,
                modifier = Modifier.rotate(45f)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            TeamInfo(team = match.homeTeam, flag = match.homeTeamFlag)
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                PredictScoreBox(
                    selectedIndex = selectedHomeIndex,
                    onItemSelected = { index ->
                        selectedHomeIndex = index
                        selectedIndex = selectedIndex.copy(first = index) // Update selected index
                    }
                )
                Spacer(modifier = Modifier.height(25.dp))
            }

            Spacer(modifier = Modifier.width(10.dp))
            Column {
                PredictScoreBox(
                    selectedIndex = selectedAwayIndex,
                    onItemSelected = { index ->
                        selectedAwayIndex = index
                        selectedIndex = selectedIndex.copy(second = index)
                    }
                )
                Spacer(modifier = Modifier.height(25.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            TeamInfo(team = match.awayTeam, flag = match.awayTeamFlag)
        }

        Button(
            onClick = {
                onIndexPass(selectedIndex)
                onSaveClick()
                onHide()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC107)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Save prediction", color = Color.Black)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                selectedHomeIndex = 0
                selectedAwayIndex = 0
                selectedIndex = Pair(0, 0) // Reset selectedIndex/.
                onHide()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Transparent),
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, Highlight)
        ) {
            Text(text = "Delete Prediction", color = Highlight)
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun PredictScoreBox(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    val listState = rememberLazyListState()

    LaunchedEffect(selectedIndex) {
        listState.animateScrollToItem(selectedIndex)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(5.dp))
                .border(
                    1.dp, Highlight, RoundedCornerShape(5.dp)
                ), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(11) { index ->
                // Display the number in a Text element
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onItemSelected(index)  // Notify parent about the selected item
                        }
                        .background(Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = index.toString(),
                        color = White,
                        style = TextStyle(
                            fontSize = 40.sp,
                            textAlign = TextAlign.Center
                        ),
                    )
                }
            }
        }
    }
}





