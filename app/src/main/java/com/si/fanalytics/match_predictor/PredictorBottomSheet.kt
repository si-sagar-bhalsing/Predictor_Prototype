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
import androidx.compose.ui.tooling.preview.Preview
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
    content: @Composable () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
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
                onHide = onHideBottomSheet
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
    onHide: () -> Unit
) {
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
                tint = Color.White,
                modifier = Modifier.rotate(45f)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            //horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            TeamInfo(team = "Germany", flag = R.drawable.ic_flag)
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                PredictScoreBox()
                Spacer(modifier = Modifier.height(25.dp))
            }

            Spacer(modifier = Modifier.width(10.dp))
            Column {
                PredictScoreBox()
                Spacer(modifier = Modifier.height(25.dp))
            }
            Spacer (modifier = Modifier.width(10.dp))
            TeamInfo(team = "Germany", flag = R.drawable.ic_flag)

        }

        Button(
            onClick = onHide,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC107)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Save prediction", color = Color.Black)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onHide,
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
fun PredictScoreBox() {
    // State to keep track of the selected item
    var selectedItem by remember { mutableStateOf(0) }
    val listState = rememberLazyListState()

    LaunchedEffect(selectedItem) {
        listState.animateScrollToItem(selectedItem)
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
                        .clickable { selectedItem = index }
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
        Column{
            PredictScoreBox()
            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPredictScoreBox() {
    PredictScoreBox()
}


