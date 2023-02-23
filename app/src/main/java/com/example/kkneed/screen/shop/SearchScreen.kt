package com.example.kkneed.screen.shop

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.ShopSearchTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

val listRecord = listOf("记录1", "记录2", "记录3")

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = { ShopSearchTopAppBar(64.dp, navController) }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.padding(top = 16.dp)) {
                Text(
                    "搜索记录",
                    style = MaterialTheme.typography.titleSmall,
                )
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(top = 8.dp)
                ) {
                    AssistChip(
                        onClick = {navController.navigate(AllScreen.SearchResult.route)},
                        modifier = Modifier.padding(horizontal = 8.dp),
                        label = { Text("可口可乐") }
                    )
                    AssistChip(
                        onClick = {navController.navigate(AllScreen.SearchResult.route)},
                        modifier = Modifier.padding(horizontal = 8.dp),
                        label = { Text("鸡胸肉") }
                    )
                    AssistChip(
                        onClick = {navController.navigate(AllScreen.SearchResult.route)},
                        modifier = Modifier.padding(horizontal = 8.dp),
                        label = { Text("轻零食") }
                    )
                }
            }
            Column(modifier = Modifier.padding(top = 16.dp)) {
                Text(
                    "搜索发现",
                    style = MaterialTheme.typography.titleSmall,
                )
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(top = 8.dp)
                ) {
                    AssistChip(
                        onClick = {navController.navigate(AllScreen.SearchResult.route)
                            },
                        modifier = Modifier.padding(horizontal = 8.dp),
                        label = { Text("饼干") }
                    )
                    AssistChip(
                        onClick = {navController.navigate(AllScreen.SearchResult.route)},
                        modifier = Modifier.padding(horizontal = 8.dp),
                        label = { Text("脱脂牛奶") }
                    )
                    AssistChip(
                        onClick = {navController.navigate(AllScreen.SearchResult.route)},
                        modifier = Modifier.padding(horizontal = 8.dp),
                        label = { Text("低卡饮品") }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewSearchScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        SearchScreen(navController)
    }
}

