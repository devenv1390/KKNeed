package com.example.kkneed.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.screen.HomeScreen
import com.example.kkneed.ui.CommunityTabBar
import com.example.kkneed.ui.CommunityTopAppBar
import com.example.kkneed.ui.HomeTopAppBar
import com.example.kkneed.ui.ShopSearchTabBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CommunityScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = { CommunityTopAppBar(64.dp, navController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ){
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                CommunityTabBar()
            }
        }
    }
}

@Preview
@Composable
fun PreviewCommunityScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        CommunityScreen(navController)
    }
}