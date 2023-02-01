package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.SecondRecordTopAppBar
import com.example.kkneed.ui.SmallInfoCard
import com.example.kkneed.ui.WatchList
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WatchScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController ,"关注列表")
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ){
            LazyColumn {
                item { WatchList() }
                item { WatchList() }
                item { WatchList() }
                item { WatchList() }
                item { WatchList() }
                item { WatchList() }
                item { WatchList() }
                item { WatchList() }
                item { WatchList() }
                item { WatchList() }
            }
        }

    }
}
@Preview
@Composable
fun WatchPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        WatchScreen(navController)
    }
}