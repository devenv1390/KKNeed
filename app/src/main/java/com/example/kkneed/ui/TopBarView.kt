package com.example.kkneed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContentState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            .height(appBarHeight),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun NotNormalTopAppBar(appBarHeight: Dp, content: @Composable () -> Unit) {
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
        verticalAlignment = Alignment.Bottom
    ) {
        content()
    }
}

@Composable
fun MyHistoryTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {    //标题栏高度
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { navController.navigate(PROFILE_ROUTE) }
                ) {
                    Icon(Icons.Outlined.ArrowBack, null)
                }
                Spacer(Modifier.padding(56.dp, 0.dp))
                Text("我的足迹")
                Spacer(Modifier.padding(56.dp, 0.dp))
                IconButton(
                    onClick = {}
                ) {
                    Icon(Icons.Outlined.MoreVert, null)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(

                modifier = Modifier.padding(bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically) {
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
//订单页顶部栏
@Composable
fun SecondProfileTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
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
//我的记录顶部栏
@Composable
fun SecondRecordTopAppBar(appBarHeight: Dp, navController: NavController){
    NotNormalTopAppBar(appBarHeight) {
        Row(
            modifier= Modifier
                .size(412.dp, 64.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.navigate(PROFILE_ROUTE) }
            ) {
                Icon(Icons.Outlined.ArrowBack, null)
            }
            Text("我的记录")
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Outlined.MoreVert, null)
            }
        }
    }
}
@Composable
fun MostUseTopAppBar(appBarHeight: Dp, navController: NavController,title:String){
    NotNormalTopAppBar(appBarHeight) {
        Row(
            modifier= Modifier
                .size(412.dp, 64.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.navigate(PROFILE_ROUTE) }
            ) {
                Icon(Icons.Outlined.ArrowBack, null)
            }
            Text(title)
            IconButton(
                onClick = {}
            ) {

            }
        }
    }
}

//商城的顶部栏
@Composable
fun ShopTopAppBar(appBarHeight: Dp, navController: NavController){
    NormalTopAppBar(appBarHeight) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SearchBar()
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Default.Menu,null)
            }
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Default.Menu,null)
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