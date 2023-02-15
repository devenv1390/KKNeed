package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kkneed.R
import com.example.kkneed.model.Product
import com.example.kkneed.ui.DetailAppBar
import com.example.kkneed.ui.DetailBottomBar
import com.example.kkneed.ui.DetailList
import com.example.kkneed.ui.DetailTabBar
import com.example.kkneed.ui.components.DetailChip
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.viewmodel.ProductViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun ScanResultScreen(
    navController: NavController,
    code: String,
    codeType: String,
    viewModel: ProductViewModel = hiltViewModel()
) {
    val products: List<Product> by viewModel.products.observeAsState(arrayListOf())
    Log.d("PRODUCTS", products.size.toString())
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    Scaffold(
        topBar = {
            DetailAppBar(appBarHeight = 64.dp, navController = navController)
        },
        bottomBar = {
            DetailBottomBar()
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ) {
            DetailList(title = "products[1].product_name", company = "products[1].brands", R.drawable.alevel)
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
        //val navController = rememberNavController()
        //ScanResultScreen(navController, "", "","","",)
    }
}