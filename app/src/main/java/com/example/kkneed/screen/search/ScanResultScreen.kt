package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.*
import com.example.kkneed.ui.components.DetailChip
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScanResultScreen(navController: NavController,code:String,codeType:String) {
    Scaffold(
        topBar = {
            DetailAppBar(appBarHeight = 64.dp, navController =navController)
        },
    bottomBar = {
        DetailBottomBar()
    }
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ) {
            DetailList(title = "可口可乐300ml","可口可乐公司")
            DetailChip(state = false, title = listOf("超级加工食品","减脂期适量","糖尿病适量"))
            Spacer(modifier = Modifier.height(12.dp))
            DetailTabBar()

        }
    }
}
@Preview
@Composable
fun ScanResultPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        ScanResultScreen(navController,"","")
    }
}