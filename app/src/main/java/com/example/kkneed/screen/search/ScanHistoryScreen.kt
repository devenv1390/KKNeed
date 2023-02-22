package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.DismissDirection.*
import androidx.compose.material.DismissValue.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.model.Product
import com.example.kkneed.screen.LoadingAnimation
import com.example.kkneed.ui.HistoryCard
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScanHistoryScreen(
    navController: NavController,
    viewModel: ProductViewModel = hiltViewModel()
) {
    val products: List<Product> by viewModel.products.observeAsState(arrayListOf())
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    var productList = products
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController = navController, "搜索记录")
        },
    )
    {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            var itemCount = products.size
            if (isLoading) itemCount++

            items(count = itemCount) { index ->
                var auxIndex = index
                if (isLoading) {
                    if (auxIndex == 0) {
                        return@items LoadingAnimation()
                    }
                    auxIndex--
                }
                val product = products[auxIndex]
                // 侧滑删除所需State
                val dismissState = rememberDismissState()
                // 按指定方向触发删除后的回调，在此处变更具体数据
                if (dismissState.isDismissed(EndToStart)) {
                    viewModel.deleteProduct(product)
                }
                SwipeToDismiss(
                    state = dismissState,
                    // animateItemPlacement() 此修饰符便添加了动画
                    modifier = Modifier.fillMaxWidth().animateItemPlacement(),
                    // 下面这个参数为触发滑动删除的移动阈值
                    dismissThresholds = { direction ->
                        FractionalThreshold(if (direction == EndToStart) 0.25f else 0.5f)
                    },
                    // 允许滑动删除的方向
                    directions = setOf(EndToStart),
                    // "背景 "，即原来显示的内容被划走一部分时显示什么
                    background = {
                        val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
                        val color by animateColorAsState(
                            targetValue = when(dismissState.targetValue){
                                Default -> MaterialTheme.colorScheme.background
                                DismissedToEnd -> MaterialTheme.colorScheme.onPrimary
                                DismissedToStart -> MaterialTheme.colorScheme.error
                            }
                        )
                        val icon = when(direction){
                            StartToEnd -> Icons.Default.Done
                            EndToStart -> Icons.Default.Delete
                        }
                        val scale by animateFloatAsState(
                            if (dismissState.targetValue == Default) 0.8f else 1.2f
                        )
                        val alignment = when (direction) {
                            StartToEnd -> Alignment.CenterStart
                            EndToStart -> Alignment.CenterEnd
                        }
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(start = 12.dp, end = 12.dp),
                            contentAlignment = alignment
                        ){
                            Icon(icon, contentDescription = "Icon", modifier = Modifier.scale(scale))
                        }
                    },

                ) {
                    // ”前景“ 显示的内容
                    HistoryCard(
                        navController = navController,
                        productName = product.productName,
                        productImage = product.imageUrl,
                        productCode = product.code
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewScanScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ScanHistoryScreen(navController)
    }
}