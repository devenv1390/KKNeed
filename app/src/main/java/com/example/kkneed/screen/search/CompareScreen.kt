package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.*
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CompareScreen(navController: NavController, barcode: String, viewModel: ProductViewModel = hiltViewModel()) {
    val productLeft = viewModel.queryProduct(barcode)
//    Log.d("m",productLeft.nutriments.energyKj100g!!.toFloat().toString())
    val productRight = viewModel.nowProduct.value
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController = navController, "产品对比")
        })
    {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CompareCard(
                            navController,
                            productLeft.productName,
                            productLeft.imageUrl,
                            productLeft.scoreGrade,
                        )
                        CompareCard(
                            navController,
                            productRight?.productName ?: productLeft.productName,
                            productRight?.productName ?: productLeft.imageUrl,
                            productRight?.productName ?: productLeft.scoreGrade,
                        )
                    }
                    Spacer(modifier = Modifier.size(12.dp))
                    NutriCompareCard(productLeft, productRight ?: productLeft)
                    Spacer(modifier = Modifier.size(12.dp))
                    ComponentCompareCard(productLeft,productRight ?: productLeft)
                }
            }
            item {
                Spacer(modifier = Modifier.size(40.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewCompareScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
//        CompareScreen(navController)
    }
}

