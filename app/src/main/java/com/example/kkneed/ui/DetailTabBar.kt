package com.example.kkneed.ui

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.kkneed.data.DetailItemData
import com.example.kkneed.data.ingredientAnalyser
import com.example.kkneed.model.Product
import com.example.kkneed.ui.theme.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailTabBar(product: Product, navController: NavController) {
    val pagerState = rememberPagerState()
    val pages = listOf("产品概览", "成分详情")
    val coroutineScope = rememberCoroutineScope()
    val defaultIndicator = @Composable { tabPositions: List<androidx.compose.material.TabPosition> ->
        TabRowDefaults.Indicator(
            Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
        )
    }
    val indicator = @Composable { tabPositions: List<androidx.compose.material.TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }
    val fat = product.nutrientLevels.fat
    val salt = product.nutrientLevels.salt
    val saturatedFat = product.nutrientLevels.saturatedFat
    val sugar = product.nutrientLevels.sugars
    val list = listOf<DetailItemData>(
        DetailItemData("脂肪", fat, LevelA),
        DetailItemData("氯化钠", salt, LevelA),
        DetailItemData("饱和脂肪", saturatedFat, LevelA),
        DetailItemData("糖", sugar, LevelA),
    )
    var advantageList = mutableListOf<DetailItemData>()
    var disadvantageList = mutableListOf<DetailItemData>()
    for (item in list) {
        if (item.value == "low" || item.value == "moderate") {
            item.color = LevelA
            item.title = item.title + "含量低"
            if (item.value == "moderate") {
                item.color = LevelC
                item.title = item.title + "含量适中"
            }
            ingredientAnalyser(item, advantageList)
        } else {
            item.color = LevelE
            item.title = item.title + "含量高"
            ingredientAnalyser(item, disadvantageList)
        }
    }
    androidx.compose.material.TabRow(
        modifier = Modifier
            .height(50.dp)
            .padding(top = 0.dp),
        backgroundColor = MaterialTheme.colorScheme.onPrimary,
        selectedTabIndex = pagerState.currentPage,
        indicator = indicator
    ) {
        pages.forEachIndexed { index, title ->
            androidx.compose.material.Tab(
                modifier = Modifier.zIndex(2f),
                text = { androidx.compose.material.Text(text = title) },
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
        modifier = Modifier.fillMaxWidth(),
        count = pages.size,
        state = pagerState,
    ) { page ->
        when (page) {
            0 -> {
                Surface(color = MaterialTheme.colorScheme.onPrimary) {
                    Column(horizontalAlignment = Alignment.Start)
                    {
                        DisadContent(product, disadvantageList, navController)
                        AdContent(product, advantageList, navController)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    "用户评价",
                                    modifier = Modifier.padding(start = 16.dp),
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    "4.37分",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    "1024条",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(
                                    "全部评论 >>",
                                    modifier = Modifier.padding(end = 16.dp),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                        CommentCard()
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                "康康商城",
                                modifier = Modifier.padding(start = 16.dp),
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            TextButton(onClick = { /*TODO*/ }) {
                                Text(
                                    "进入商城 >>",
                                    modifier = Modifier.padding(end = 16.dp),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }

                        }
                        DetailShopCard()
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                "同类优选商品",
                                modifier = Modifier.padding(start = 16.dp),
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        LazyRow(
                            modifier = Modifier.padding(start = 16.dp)
                        ) {

                            item { ProductCard("百事无糖可乐") }
                            item { Spacer(modifier = Modifier.width(8.dp)) }
                            item { ProductCard("百事无糖可乐") }
                            item { Spacer(modifier = Modifier.width(8.dp)) }
                            item { ProductCard("百事无糖可乐") }
                            item { Spacer(modifier = Modifier.width(8.dp)) }
                            item { ProductCard("百事无糖可乐") }
                            item { Spacer(modifier = Modifier.width(8.dp)) }
                            item { ProductCard("百事无糖可乐") }
                        }
                        Spacer(modifier = Modifier.height(80.dp))

                    }
                }

            }

            1 -> {
                Surface(color = MaterialTheme.colorScheme.onPrimary) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.height(12.dp))
                        NutritionCard(product)
                        Spacer(modifier = Modifier.height(12.dp))
                        ComponentCard(product)
                    }
                }
            }
        }
    }
}

//缺点内容
@Composable
fun DisadContent(product: Product, list: MutableList<DetailItemData>, navController: NavController) {
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = "缺点",
        modifier = Modifier.padding(start = 16.dp),
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.onBackground
    )
    list.forEachIndexed { _, item ->
        VantageList(item.title, item.color, navController)
    }
}

//优点内容
@Composable
fun AdContent(product: Product, list: MutableList<DetailItemData>, navController: NavController) {
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = "优点",
        modifier = Modifier.padding(start = 16.dp),
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.onBackground
    )
    list.forEachIndexed { _, item ->
        VantageList(item.title, item.color, navController)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<androidx.compose.material.TabPosition>, pagerState: PagerState) {
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


@Composable
@Preview
fun TabPreview() {
    KKNeedTheme {

    }
}