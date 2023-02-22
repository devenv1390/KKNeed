package com.example.kkneed.screen.customize

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.model.Product
import com.example.kkneed.navigation.SCANNER_ROUTE
import com.example.kkneed.navigation.SHOP_ROUTE
import com.example.kkneed.screen.login.RandomPosition
import com.example.kkneed.ui.*
import com.example.kkneed.ui.components.CustomizeChip
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.md_theme_dark_primary
import com.example.kkneed.viewmodel.ProductViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun CustomizeScreen(
    navController: NavController,
    viewModel:ProductViewModel = hiltViewModel()
    ) {
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    val products:List<Product> by viewModel.products.observeAsState(arrayListOf())
    val isLoading:Boolean by viewModel.isLoading.observeAsState(false)
    ModalBottomSheetLayout(
        sheetElevation = 16.dp,
        sheetState = state,
        sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        sheetContent = {
            ChoseBottomSheet(state,scope)
        }
    ) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = { CustomizeTopAppBar(64.dp, navController) },
        bottomBar = {
            MyBottomNavigation(navController = navController,2)
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(SCANNER_ROUTE)
                },
                backgroundColor = md_theme_dark_primary
            ) {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.barcode_scanner),
                    null,
                    tint = Color.White,
                    modifier = Modifier.height(24.dp)
                )
            }
        }
    ) {
        ChoseBottomSheet(state,scope)
        LazyColumn(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                ) {
                    CustomizeChip(title = "可可代脂肪",
                        modifier = Modifier.RandomPosition(120, 30)
                    )

                    CustomizeChip( title = "饱和脂肪",
                        modifier = Modifier.RandomPosition(800, 150)
                    )
                    CustomizeChip(title = "乳糖",
                        modifier = Modifier.RandomPosition(80, 300)
                    )
                    CustomizeChip( title = "添加糖",
                        modifier = Modifier.RandomPosition(200, 500)
                    )
                    CustomizeChip(title = "钠",
                        modifier = Modifier.RandomPosition(800, 400)
                    )
                    Image(
                        painter = painterResource(R.drawable.human),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(160.dp, 210.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopCenter,
                    )
                }
            }

//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
                item {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)){
                        Icon(painter = painterResource(id = R.drawable.centerfocus),
                            null)
                        Text(text = "关注标签",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.padding(start = 8.dp))
                    }
                    CustmizeCard()
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Icon(painter = painterResource(id = R.drawable.info),null,
                                modifier = Modifier.size(48.dp))
                            Text(text = "健康档案",style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.padding(start = 8.dp))
                        }
                        IconButton(onClick = { scope.launch { state.show() } }) {
                            Icon(painter = painterResource(id = R.drawable.edit),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp))
                        }
                    }
                    HealthCard("健身记录",R.drawable.fire,R.drawable.sportpie,"177","千卡")
                    HealthCard2("腹部绞痛",R.drawable.fire,"出现/轻微","")
                    HealthCard("经期跟踪",R.drawable.fire,R.drawable.open,"月经量","三天前")
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically){
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Icon(painter = painterResource(id = R.drawable.centerfocus),null)
                            Text(text = "推荐食品",style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.padding(start = 8.dp))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically){
                            TextButton(onClick = { navController.navigate(SHOP_ROUTE) }) {
                                Text(text = "进入商城",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary)
                            }
                            Icon(Icons.Default.KeyboardArrowRight,null,modifier = Modifier.size(24.dp),
                                tint=MaterialTheme.colorScheme.primary)
                        }

                    }
                }
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
                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }

        }
    }
    }
//    }


@Preview
@Composable
fun Temp() {
    KKNeedTheme {
        val navController = rememberNavController()
        CustomizeScreen(navController)
    }

}