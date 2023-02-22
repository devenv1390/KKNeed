package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.model.Product
import com.example.kkneed.ui.HistoryCard
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.viewmodel.ProductViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScanHistoryScreen(
    navController: NavController,
    viewModel:ProductViewModel = hiltViewModel()
) {
    val products:List<Product> by viewModel.products.observeAsState(arrayListOf())
    val isLoading:Boolean by viewModel.isLoading.observeAsState(false)
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "搜索记录") },
    )
    {
        LazyColumn(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)){
            var itemCount = products.size
            if(isLoading) itemCount++

            items(count = itemCount){index ->
                var auxIndex = index
                if(isLoading){
                    if (auxIndex == 0){
//                        return@items LoadingCard()
                    }
                    auxIndex--
                }
                val product = products[auxIndex]
                HistoryCard(
                    productName = product.product_name,
                    productImage = product.image_url
                )
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