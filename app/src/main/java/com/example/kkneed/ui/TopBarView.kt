package com.example.kkneed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kkneed.navigation.PROFILE_ROUTE
import com.example.kkneed.ui.theme.KKNeedTheme


@Composable
fun MyTopAppBar(content: @Composable () -> Unit) {
    //标题栏高度
    val appBarHeight = 56.dp
    //状态栏颜色读取
//    val systemUiController = rememberSystemUiController()
//    LaunchedEffect(key1 = Unit) {
//        systemUiController.setStatusBarColor(Color.Transparent)
//    }
    //状态栏高度
    val statusBarHeightDp = LocalDensity.current.run {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    Row(
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.secondaryContainer
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun NormalTopAppBar(appBarHeight: Dp, content: @Composable () -> Unit) {
    //标题栏高度

    //状态栏高度
    val statusBarHeightDp = LocalDensity.current.run {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    Row(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.secondaryContainer, // 这里可以加无数个
                        MaterialTheme.colorScheme.background,
                    ),
                )
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun MyHistoryTopAppBar(appBarHeight: Dp, navController: NavController) {
    NormalTopAppBar(appBarHeight) {    //标题栏高度
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { navController.navigate(PROFILE_ROUTE) }
                ) {
                    Icon(Icons.Outlined.ArrowBack, null)
                }
                Spacer(Modifier.padding(60.dp, 0.dp))
                Text("我的足迹")
                Spacer(Modifier.padding(60.dp, 0.dp))
                IconButton(
                    onClick = {}
                ) {
                    Icon(Icons.Outlined.MoreVert, null)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "今天",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(Modifier.padding(140.dp, 0.dp))
                Text(
                    "1/19",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

@Composable
fun SecondProfileTopAppBar(appBarHeight: Dp, navController: NavController) {
    NormalTopAppBar(appBarHeight) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    navController.navigate(PROFILE_ROUTE)
                }
            ) {
                Icon(Icons.Default.ArrowBack, null)
            }
            SearchBar()
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Default.Call, null)
            }
        }
    }
}

@Preview
@Composable
fun PreviewTopAppBar() {
    KKNeedTheme {

    }
}