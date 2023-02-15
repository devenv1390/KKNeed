package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ProductViewModel
import com.example.kkneed.R
import com.example.kkneed.ui.DetailAppBar
import com.example.kkneed.ui.DetailBottomBar
import com.example.kkneed.ui.DetailList
import com.example.kkneed.ui.DetailTabBar
import com.example.kkneed.ui.components.DetailChip
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun ScanResultScreen(
    navController: NavController,
    code: String,
    codeType: String,
    viewModel: ProductViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            DetailAppBar(appBarHeight = 64.dp, navController = navController)
        },
        bottomBar = {
            DetailBottomBar()
        }
    ) {
        //进行查询条码工作
        viewModel.getProduct("3017624010701")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ) {
            DetailList(title = "可口可乐300ml", "可口可乐公司", R.drawable.alevel)
            DetailChip(state = false, title = listOf("超级加工食品", "减脂期适量", "糖尿病适量"))
            Spacer(modifier = Modifier.height(12.dp))
            DetailTabBar()

        }
    }
}

@Preview
@Composable
fun ScanResultPreview() {
    KKNeedTheme {

    }
}