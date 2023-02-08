package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.kkneed.ui.ShopScreenMainCard
import com.example.kkneed.ui.components.ChipGroupCompose
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CommentScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "全部评论") })
    {
        val pagerState = rememberPagerState()
        ChipGroupCompose()
        //progressBar()




    }
}


@Preview
@Composable
fun CommentPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        CommentScreen(navController)
    }
}
