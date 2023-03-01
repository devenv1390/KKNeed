package com.example.kkneed.screen.search

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.screen.LoadingAnimation
import com.example.kkneed.viewmodel.ProductViewModel
import kotlinx.coroutines.delay

@Composable
fun ScanLoadingScreen(navController: NavController, barcode: String, viewModel: ProductViewModel = hiltViewModel()) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        val tempProduct = viewModel.hasProduct(barcode)
        delay(5000)
        Log.d("RES", tempProduct.statusVerbose)
        if (tempProduct.status == 0) {
            Toast.makeText(context,tempProduct.statusVerbose,Toast.LENGTH_LONG).show()
            navController.popBackStack()
        } else {
            viewModel.addProduct(barcode)
            delay(9000)
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