package com.example.kkneed.screen.search

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
        viewModel.addProduct(barcode)
        delay(10000)
        navController.popBackStack()
        navController.navigate(AllScreen.ScanResult.route + "/${barcode}")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LoadingAnimation()
    }
}