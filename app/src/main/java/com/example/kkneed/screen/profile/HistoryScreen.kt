package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.MyHistoryTopAppBar
import com.example.kkneed.ui.SmallInfoCard
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HistoryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyHistoryTopAppBar(108.dp, navController)
        },
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(top = 8.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(){
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

@Preview
@Composable
fun HisPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        HistoryScreen(navController)
    }
}