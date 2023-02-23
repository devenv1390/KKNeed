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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.kkneed.R
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.ShopScreenMainCard
import com.example.kkneed.ui.components.ChipGroupCompose
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CommentScreen(navController: NavController) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "全部评论") },
        bottomBar = {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 28.dp),
                horizontalArrangement = Arrangement.Center){
                GradientButton(modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.8f),
                    textId = "我也要点评", onClick = {

                    }
                )
            }
        },
    floatingActionButton = {
        FloatingActionButton(shape = RoundedCornerShape(12.dp),onClick = {
            coroutineScope.launch {
            // Animate scroll to the first item
            listState.animateScrollToItem(index = 0)
        } }) {
            Icon(painter = painterResource(id = R.drawable.up),
                null, tint = Color.White)
        }
    })
    {
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
