package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.DetailCard
import com.example.kkneed.ui.DetailList
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.VantageList
import com.example.kkneed.ui.components.ChipGroupCompose
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.LevelE
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "详情") })
    {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)){
            DetailList(title = "卡路里值偏高 10.6%", LevelE)
            DetailCard("康康小贴士","过高的摄入脂肪（尤其是饱和脂肪），会导致胆固醇升高，从而增加患心脏病的风险。")
            DetailCard("康康有话说","购买产品时要选择低脂肪以及低饱和脂肪的产品，从而保护身体健康喔~")
            Row(modifier = Modifier.fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.Start) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        "点击链接查看更多脂肪科普小知识",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            }
        }


    }

@Preview
@Composable
fun DetailPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        DetailScreen(navController)
    }
}