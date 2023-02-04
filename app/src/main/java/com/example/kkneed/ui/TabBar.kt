package com.example.kkneed.ui


import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.screen.login.SignInScreen
import com.example.kkneed.ui.theme.KKNeedTheme
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabBar() {
    val pagerState = rememberPagerState()
    val pages = listOf("全部","待付款","待发货","待收货","待评价")
    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
        TabRowDefaults.Indicator(
            Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
        )
    }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    TabRow(
        modifier = Modifier
            .height(50.dp)
            .padding(top = 0.dp),
        backgroundColor = MaterialTheme.colorScheme.onPrimary,
        selectedTabIndex = pagerState.currentPage,
        indicator = indicator
    ) {
        pages.forEachIndexed { index, title ->
            Tab(
                modifier = Modifier.zIndex(5f),
                text = { Text(text = title) },
                selected = pagerState.currentPage == index,
                onClick = { /* TODO */ },
            )
        }
    }

    //设置页面内容
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        count = pages.size,
        state = pagerState,
    ) { page ->
        Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
                )
            {
                item { OrderInfoCard("12345678910111213","待支付") }
                item{ Spacer(modifier =Modifier.height(8.dp))}
                item { OrderInfoCard("12345678910111213","待支付") }


            }
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage)
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary, RoundedCornerShape(50))
            .border(
                BorderStroke(2.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                RoundedCornerShape(50)
            )
            .zIndex(1f)
    )
}

//商城搜索结果界面的
@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShopSearchTabBar() {
    val pagerState = rememberPagerState()
    val pages = listOf("综合","评分","价格","销量")
    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
        TabRowDefaults.Indicator(
            Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
        )
    }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    TabRow(
        modifier = Modifier
            .height(50.dp)
            .padding(top = 0.dp),
        backgroundColor = MaterialTheme.colorScheme.onPrimary,
        selectedTabIndex = pagerState.currentPage,
        indicator = indicator
    ) {
        pages.forEachIndexed { index, title ->
            Tab(
                modifier = Modifier.zIndex(4f),
                text = { Text(text = title) },
                selected = pagerState.currentPage == index,
                onClick = { /* TODO */ },
            )
        }
    }

    //设置页面内容
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        count = pages.size,
        state = pagerState,
    ) { page ->
        Surface(color = MaterialTheme.colorScheme.background) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            )
            {
                item { ShopScreenMainCard() }
                item { ShopScreenMainCard() }
                item { ShopScreenMainCard() }
                item { ShopScreenMainCard() }
                item { ShopScreenMainCard() }
                item { ShopScreenMainCard() }
                item { ShopScreenMainCard() }
            }
        }

    }
}


@Composable
@Preview
fun SignUpScreenPreview() {
    KKNeedTheme {
        ShopSearchTabBar()
    }
}
