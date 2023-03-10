package com.example.kkneed.ui


import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.kkneed.ui.theme.KKNeedTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabBar() {
    val pagerState = rememberPagerState()
    val pages = listOf("全部", "待付款", "待发货", "待收货", "待评价")
    val coroutineScope = rememberCoroutineScope()
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
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }

    //设置页面内容
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        count = pages.size,
        state = pagerState,
    ) { page ->
        when(page){
            0->
            {
                Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        item { OrderInfoCard("12345678910111213", "待支付") }
                        item { OrderInfoCard1("12345678910111213", "运输中") }
                        item { OrderInfoCard2("12345678910111213", "已完成") }
                        item { OrderInfoCard3("12345678910111213", "待发货") }
                        item{Spacer(modifier = Modifier.height(16.dp))}


                    }
                }
            }
            1->{
                Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        item { OrderInfoCard("12345678910111213", "待支付") }
                        item { OrderInfoCard("12345678910111213", "待支付") }
                        item { OrderInfoCard("12345678910111213", "待支付") }
                        item{Spacer(modifier = Modifier.height(16.dp))}
                    }
                }
            }
            2->{
                Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        item { OrderInfoCard3("12345678910111213", "待发货") }
                        item { OrderInfoCard3("12345678910111213", "待发货") }
                        item { OrderInfoCard3("12345678910111213", "待发货") }
                        item { OrderInfoCard3("12345678910111213", "待发货") }
                        item{Spacer(modifier = Modifier.height(16.dp))}
                    }
                }
            }
            3->{
                Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        item { OrderInfoCard1("12345678910111213", "运输中") }
                        item { OrderInfoCard1("12345678910111213", "运输中") }
                        item { OrderInfoCard1("12345678910111213", "运输中") }
                        item{Spacer(modifier = Modifier.height(16.dp))}

                    }
                }
            }
            4->{
                Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        item { OrderInfoCard2("12345678910111213", "已完成") }
                        item { OrderInfoCard2("12345678910111213", "已完成") }
                        item { OrderInfoCard2("12345678910111213", "已完成") }
                        item { OrderInfoCard2("12345678910111213", "已完成") }
                        item { OrderInfoCard2("12345678910111213", "已完成") }
                        item{Spacer(modifier = Modifier.height(16.dp))}
                    }
                }
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
            .background(color = MaterialTheme.colorScheme.inversePrimary, RoundedCornerShape(50))
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
fun ShopSearchTabBar(navController: NavController) {
    val pagerState = rememberPagerState()
    val pages = listOf("综合", "评分", "价格", "销量")
    val coroutineScope = rememberCoroutineScope()
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
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
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
                item { ShopScreenMainCard(navController ) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item{Spacer(modifier = Modifier.height(16.dp))}
            }
        }

    }
}

//我的收藏tab栏
@OptIn(ExperimentalPagerApi::class)
@Composable
fun CollectTabBar(navController: NavController) {
    val pagerState = rememberPagerState()
    val pages = listOf("产品", "帖子")
    val coroutineScope = rememberCoroutineScope()
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
                modifier = Modifier.zIndex(2f),
                text = { Text(text = title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }

    //设置页面内容
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        count = pages.size,
        state = pagerState,
    ) { page ->
        when (page) {
            0 -> {
                Surface(color = MaterialTheme.colorScheme.onPrimary) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp)
                    )
                    {
                        item { ShopScreenMainCard(navController) }
                        item { ShopScreenMainCard(navController) }
                        item { ShopScreenMainCard(navController) }
                        item { ShopScreenMainCard(navController) }
                        item { ShopScreenMainCard(navController) }
                        item { ShopScreenMainCard(navController) }
                        item{Spacer(modifier = Modifier.height(16.dp))}
                    }
                }
            }
            1 -> {
                Surface(color = MaterialTheme.colorScheme.onPrimary) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item { SmallInfoCard(navController) }
                        item{Spacer(modifier = Modifier.height(16.dp))}
                    }
                }
            }
        }


    }
}

//社区的
@OptIn(ExperimentalPagerApi::class)
@Composable
fun CommunityTabBar(navController: NavController) {
    val pagerState = rememberPagerState()
    val pages = listOf("全部", "高赞", "健康", "美食", "知识")
    val coroutineScope = rememberCoroutineScope()
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
                onClick = { coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                } },
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
                item {
                    Row(modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                        CommunityCard(navController)
                        CommunityCard(navController) }
                     }
                item {
                    Row(modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        CommunityCard(navController)
                        CommunityCard(navController) }
                }
                item {
                    Row(modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        CommunityCard(navController)
                        CommunityCard(navController) }
                }
                item {
                    Row(modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        CommunityCard(navController)
                        CommunityCard(navController) }
                }
                item {
                    Row(modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        CommunityCard(navController)
                        CommunityCard(navController) }
                }
                item {
                    Row(modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        CommunityCard(navController)
                        CommunityCard(navController) }
                }
                item{Spacer(modifier = Modifier.height(16.dp))}
            }
        }
    }
}


@Composable
@Preview
fun SignUpScreenPreview() {
    KKNeedTheme {
    }
}
