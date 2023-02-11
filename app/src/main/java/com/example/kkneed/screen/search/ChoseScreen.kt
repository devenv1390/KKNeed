package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.screen.profile.RecordScreen
import com.example.kkneed.ui.HistoryCard
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChoseScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "选择产品")
        }
    ){
        val listState = rememberLazyListState()
        // Remember a CoroutineScope to be able to launch
        val coroutineScope = rememberCoroutineScope()
        LazyColumn(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = listState){
            item { HistoryCard() }
            item { HistoryCard() }
            item { HistoryCard() }
            item { HistoryCard() }
            item { HistoryCard() }
            item { HistoryCard() }
            item { HistoryCard() }
            item { HistoryCard() }
            item { HistoryCard() }
            item { HistoryCard() }
        }
    }
}
@Preview
@Composable
fun ChosePreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        ChoseScreen(navController)
    }
}