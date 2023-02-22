package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kkneed.ui.DetailAppBar
import com.example.kkneed.ui.DetailBottomBar
import com.example.kkneed.ui.DetailList
import com.example.kkneed.ui.DetailTabBar
import com.example.kkneed.ui.components.DetailChip
import com.example.kkneed.viewmodel.ProductViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun ResultScreen(
    navController: NavController,
    code: String,
    viewModel: ProductViewModel = hiltViewModel(),
) {
    viewModel.barcode = code
    Log.d("CODE",code)
    val product = viewModel.queryProduct(code)
    Scaffold(
        topBar = {
            DetailAppBar(appBarHeight = 64.dp, navController = navController)
        },
        bottomBar = {
            DetailBottomBar()
        }
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ) {
            item {
                    DetailList(
                        product.productName,
                        product.brands,
                        product.imageUrl,
                        product.nutriScoreGrade,
                    )
            }
            item {
                DetailChip(state = false, title = listOf("超级加工食品", "减脂期适量", "糖尿病适量"))
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                DetailTabBar()
            }
        }
    }
}