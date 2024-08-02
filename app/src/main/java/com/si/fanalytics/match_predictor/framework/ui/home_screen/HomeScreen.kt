package com.si.fanalytics.match_predictor.framework.ui.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(modifier: Modifier,viewModel: HomeScreenViewModel= hiltViewModel()){
    val data=viewModel.uiState.collectAsState().value
    val columnState= rememberLazyListState()
    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(state = columnState, modifier = Modifier.padding(8.dp)) {
            itemsIndexed( data.fixtures){ index,fixture->
                Text(text = "${fixture} \n")
            }
        }

    }
}