package com.example.kkneed.screen.search

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.screen.LoadingAnimation
import com.example.kkneed.viewmodel.ProductViewModel
import kotlinx.coroutines.delay

@Composable
fun ScanLoadingScreen(navController: NavController, barcode: String, viewModel: ProductViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = true) {
        var flag = true
        try {
            viewModel.addProduct(barcode)
            delay(10000)
            val product = viewModel.queryProductCode(barcode)
            Log.d("RES", product.productName)
        } catch (e: Exception) {
            flag = false
        }
//        viewModel.addProduct(barcode)
//        delay(10000)
        if(flag){
            navController.popBackStack()
        }else {
            navController.popBackStack()
            navController.navigate(AllScreen.ScanResult.route + "/${barcode}")
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LoadingAnimation()
    }
}