package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.HistoryCard
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.SmallInfoCard
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScanHistoryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "搜索记录") },
    )
    {
        LazyColumn(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)){
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
fun PreviewScanScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ScanHistoryScreen(navController)
    }
}