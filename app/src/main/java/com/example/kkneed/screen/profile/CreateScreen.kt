package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.CollectTabBar
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.SmallInfoCard
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "我的创作")
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()
            .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)){
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
            item{ Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}
@Preview
@Composable
fun CreatePreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        CreateScreen(navController)
    }
}