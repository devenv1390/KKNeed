package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.screen.search.EditScreen
import com.example.kkneed.ui.CollectTabBar
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CollectScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "我的收藏")
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            CollectTabBar(navController)
        }
    }
}
@Preview
@Composable
fun EditPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        CollectScreen(navController)
    }
}