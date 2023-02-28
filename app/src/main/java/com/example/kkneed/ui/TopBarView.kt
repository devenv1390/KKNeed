package com.example.kkneed.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.theme.KKNeedTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun MyTopAppBar(content: @Composable () -> Unit) {
    //标题栏高度
    val appBarHeight = 56.dp
    //状态栏颜色读取
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = Unit) {
        systemUiController.setStatusBarColor(Color.Transparent, true)
    }
    //状态栏高度
    val statusBarHeightDp = LocalDensity.current.run {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    Row(
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.secondaryContainer
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun MyTopAppBar2(content: @Composable () -> Unit) {
    //标题栏高度
    val appBarHeight = 2.dp
    //状态栏颜色读取
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = Unit) {
        systemUiController.setStatusBarColor(Color.Transparent, true)
    }
    //状态栏高度
    val statusBarHeightDp = LocalDensity.current.run {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    Row(
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.onPrimary
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun NormalTopAppBar(appBarHeight: Dp, content: @Composable () -> Unit) {
    //标题栏高度
    Row(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.secondaryContainer, // 这里可以加无数个
                        MaterialTheme.colorScheme.background,
                    ),
                )
            )
            .fillMaxWidth()
            .height(appBarHeight),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun NotNormalTopAppBar(appBarHeight: Dp, content: @Composable () -> Unit) {
    //标题栏高度
    //状态栏高度
    val statusBarHeightDp = LocalDensity.current.run {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = Unit) {
        systemUiController.setStatusBarColor(Color.Transparent, true)
    }
    Row(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.secondaryContainer, // 这里可以加无数个
                        MaterialTheme.colorScheme.background,
                    ),
                )
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        content()
    }
}

@Composable
fun NormalTopAppBar2(appBarHeight: Dp, content: @Composable () -> Unit) {
    //标题栏高度
    //状态栏高度
    val statusBarHeightDp = LocalDensity.current.run {
        WindowInsets.statusBars.getTop(this).toDp()
    }
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = Unit) {
        systemUiController.setStatusBarColor(Color.Transparent, false)
    }
    Row(
        modifier = Modifier
            .background(Color.Transparent)

            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        content()
    }
}

@Composable
fun MyHistoryTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {    //标题栏高度
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                BackButton(navController)
                Spacer(Modifier.padding(56.dp, 0.dp))
                Text("我的足迹")
                Spacer(Modifier.padding(56.dp, 0.dp))
                IconButton(
                    onClick = {}
                ) {
                    Icon(Icons.Outlined.MoreVert, null)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(

                modifier = Modifier.padding(bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "今天",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(Modifier.padding(140.dp, 0.dp))
                Text(
                    "1/19",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

//订单页顶部栏
@Composable
fun OrderProfileTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BackButton(navController)
            SearchBar()
            IconButton(
                onClick = {navController.navigate(AllScreen.Service.route)}
            ) {
                Icon(painter = painterResource(id = R.drawable.service), null)
            }
        }
    }
}

//我的记录顶部栏
@Composable
fun SecondRecordTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            modifier = Modifier
                .size(412.dp, 64.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackButton(navController)
            Text("我的记录")
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Outlined.MoreVert, null)
            }
        }
    }
}

@Composable
fun MostUseTopAppBar(appBarHeight: Dp, navController: NavController, title: String) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            modifier = Modifier
                .size(412.dp, 64.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackButton(navController)
            Text(title)
            IconButton(
                onClick = {}
            ) {

            }
        }
    }
}

//商城的顶部栏
@Composable
fun ShopTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ShopSearchBar(navController)
            IconButton(
                onClick = { navController.navigate(AllScreen.ShoppingCart.route) }
            ) {
                Icon(Icons.Outlined.ShoppingCart, null)
            }
            IconButton(
                onClick = { navController.navigate(AllScreen.Service.route) }
            ) {
                Icon(painter = painterResource(id = R.drawable.support_agent), null, modifier = Modifier.size(24.dp))
            }
        }
    }
}

//商城搜索顶部
@Composable
fun ShopSearchTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BackButton(navController)
            SearchBar()
            TextButton(onClick = {}) {
                Text("搜索")
            }
        }
    }
}

//搜索页面顶部栏
@Composable
fun ScanTopAppBar(appBarHeight: Dp, navController: NavController) {
    NormalTopAppBar2(appBarHeight) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Surface(
                shape = RoundedCornerShape(12),
                modifier = Modifier.size(40.dp)
            ) {
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    ),
                    onClick = { navController.popBackStack() }) {
                    Icon(Icons.Outlined.ArrowBack, null)
                }
            }
            SearchBar()
            Surface(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.size(40.dp)
            ) {
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    ),
                    onClick = { navController.navigate(AllScreen.ScanHistory.route) }) {
                    Icon(painter = painterResource(id = R.drawable.history), null)
                }
            }
        }
    }
}

@Composable
fun DetailAppBar(appBarHeight: Dp, navController: NavController, context: Context, barcode:String) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            modifier = Modifier
                .size(412.dp, 64.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackButton(navController)
            Text("")
            IconButton(
                onClick = {
                    context.startActivity(
                        Intent.createChooser(
                            Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, barcode)
                                type = "text/plain"
                            },
                            context.getString(R.string.scan_share_value)
                        )
                    )
                }
            ) {
                Icon(painter = painterResource(R.drawable.share), null)

            }
        }
    }
}

//首页（只有文字部分）
@Composable
fun HomeTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            modifier = Modifier
                .size(412.dp, 64.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            BackButton(navController)
            IconButton(
                onClick = {}
            ) {
            }
            Text("康康Need")
            IconButton(
                onClick = {}
            ) {
            }
        }
    }
}

//首页（只有文字部分）
@Composable
fun CustomizeTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            modifier = Modifier
                .size(412.dp, 64.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            BackButton(navController)
            IconButton(
                onClick = {}
            ) {
            }
            Text("定制")
            IconButton(
                onClick = {}
            ) {
            }
        }
    }
}

//社区顶部
@Composable
fun CommunityTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BackButton(navController)
            CommunitySearchBar(navController)
            IconButton(
                onClick = { navController.navigate(AllScreen.EditNote.route) }
            ) {
                Icon(Icons.Outlined.Edit, null)
            }
        }
    }
}

//帖子顶部
@Composable
fun NoteTopAppBar(appBarHeight: Dp, navController: NavController) {
    NotNormalTopAppBar(appBarHeight) {
        Row(
            modifier = Modifier
                .size(412.dp, 64.dp)
                .padding(start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackButton(navController)
            Text("详情")
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Outlined.Share, null)
            }
        }
    }
}

@Preview
@Composable
fun PreviewTopAppBar() {
    KKNeedTheme {
        val navController = rememberNavController()
        ScanTopAppBar(64.dp, navController)
    }
}