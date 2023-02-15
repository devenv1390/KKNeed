package com.example.kkneed.screen

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kkneed.R
import com.example.kkneed.data.GuideScreenItemData
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.CustomProgress
import com.example.kkneed.ui.IndicatorHorizontal
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@Composable
fun Indicator(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        repeat(size) {
            IndicatorHorizontal(isSelected = it == index)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun GuideScreen(navController: NavController) {
    val items = listOf<GuideScreenItemData>(
        GuideScreenItemData(
            R.drawable.frame1,
            "找寻食品信息",
            "科学评判你能买到的预包装食品，准确记录食品信息，健康生活暖宝宝。"
        ),
        GuideScreenItemData(
            R.drawable.frame2,
            "计划健康生活",
            "每天打开一俩次，健康生活一辈子。在这找到属于你的饮食计划，规划你的健康生活。"
        ),
        GuideScreenItemData(
            R.drawable.frame3,
            "发现养生好物",
            "选择我们，就是选择健康。商城养生好物，等待你的加购。健康生活知识，等待你的发现。"
        )
    )
    val state = rememberPagerState(initialPage = 0)
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(count = 3, state = state) {
            CustomProgress(items[it])
        }
        Indicator(size = items.size, index = state.currentPage)

        val width = animateDpAsState(
            targetValue = if (state.currentPage.inc() == items.size) 60.dp else 0.dp,
            animationSpec = if (state.currentPage.inc() == items.size)
                spring(dampingRatio = Spring.DampingRatioHighBouncy)
            else
                spring(dampingRatio = Spring.DampingRatioMediumBouncy)
        )

        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FloatingActionButton(
                onClick = {
                          navController.navigate(AllScreen.SignUp.route)
                },
                backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                modifier = Modifier.size(width.value)
            ) {
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}