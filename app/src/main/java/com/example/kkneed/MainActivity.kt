package com.example.kkneed

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val items = listOf<ItemData>(
        ItemData(
            R.drawable.frame1,
            "找寻食品信息",
            "科学评判你能买到的预包装食品，准确记录食品信息，健康生活暖宝宝。"
        ),
        ItemData(
            R.drawable.frame2,
            "计划健康生活",
            "每天打开一俩次，健康生活一辈子。在这找到属于你的饮食计划，规划你的健康生活。"
        ),
        ItemData(
            R.drawable.frame3,
            "发现养生好物",
            "选择我们，就是选择健康。商城养生好物，等待你的加购。健康生活知识，等待你的发现。"
        )
    )

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KKNeedTheme {
                val state = rememberPagerState(initialPage = 0)
                // A surface container using the 'background' color from the theme

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    HorizontalPager(count = 3,state = state) {
                        CustomProgress(items[it])
                    }
                    Indicator(size = items.size, index = state.currentPage)

                    val width = animateDpAsState(
                        targetValue = if(state.currentPage.inc() == items.size) 60.dp else 0.dp,
                        animationSpec = if(state.currentPage.inc() == items.size)
                            spring(dampingRatio = Spring.DampingRatioHighBouncy)
                        else
                            spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                    )

                    Row(
                        modifier = Modifier.height(100.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        FloatingActionButton(
                            onClick = { },
                            backgroundColor = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(width.value)
                        ){
                            Icon(
                                Icons.Default.ArrowForward,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
//                Sample()
            }
        }
    }
}

data class Item(
    val index: Int,
    val name: String,
    val icon: ImageVector,
)

@Composable
fun Indicator(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        repeat(size) {
            IndicatorHorizontal(isSelected = it == index)
        }
    }
}

@Composable
fun MySnackBar(snackbarHostState: SnackbarHostState, onDismiss: () -> Unit) {
    SnackbarHost(hostState = snackbarHostState, snackbar = { data ->
        Snackbar(modifier = Modifier.padding(12.dp), action = {
            data.actionLabel?.let {
                TextButton(onClick = { onDismiss }) {
                    Text(text = it)
                }
            }
        }) {
            Text(text = data.message)
        }
    })
}

@Composable
fun MyBottomNavigation() {//第二种设计方案，采用BottomAppBar与BottomNavigationItem结合的方式，解决了选项卡按下后没有外观变化的缺点，但动画和按键的布局范围比较难控制
    var selectedItem by remember { mutableStateOf(0) }
    val themeString = androidx.compose.material3.MaterialTheme.colorScheme
    val items = listOf(
        Item(0, "主页", icon = Icons.Default.Home),
        Item(1, "商城", icon = Icons.Default.ShoppingCart),
        Item(2, "记录", icon = Icons.Default.Check),
        Item(3, "个人", icon = Icons.Default.Person)
    )
    Surface(
        shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp),
        color = themeString.secondaryContainer,
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
            )
            .fillMaxWidth()
            .size(412.dp, 60.dp)
    ) {
        BottomAppBar(
            cutoutShape = RoundedCornerShape(50),
            contentPadding = PaddingValues(5.dp, 5.dp),
            backgroundColor = themeString.background,
//            modifier = Modifier.shadow(
//                elevation = 15.dp,
//            )
        ) {
//        items.forEachIndexed{index, item ->
//            BottomNavigationItem(
//                selected = selectedItem == index,
//                onClick = {selectedItem = index},
//                icon = { Icon(item.icon,null)},
//                alwaysShowLabel = false,
//                label = { Text(item.name)},
//            )
//        }//不能采用遍历的方式创建导航选项卡，因为选项卡需要单独设置间隔值
            BottomNavigationItem(
                selected = selectedItem == 0,
                onClick = { selectedItem = 0 },
                icon = { Icon(items[0].icon, null) },
                alwaysShowLabel = false,
                label = { Text(items[0].name) },
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)
            )
            BottomNavigationItem(
                selected = selectedItem == 1,
                onClick = { selectedItem = 1 },
                icon = { Icon(items[1].icon, null) },
                alwaysShowLabel = false,
                label = { Text(items[1].name) },
                modifier = Modifier.padding(0.dp, 0.dp, 40.dp, 0.dp)
            )
            BottomNavigationItem(
                selected = selectedItem == 2,
                onClick = { selectedItem = 2 },
                icon = { Icon(items[2].icon, null) },
                alwaysShowLabel = false,
                label = { Text(items[2].name) },
                modifier = Modifier.padding(40.dp, 0.dp, 0.dp, 0.dp)
            )
            BottomNavigationItem(
                selected = selectedItem == 3,
                onClick = { selectedItem = 3 },
                icon = { Icon(items[3].icon, null) },
                alwaysShowLabel = false,
                label = { Text(items[3].name) },
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)
            )
        }
    }


}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Sample() {
    val themeString = androidx.compose.material3.MaterialTheme.colorScheme
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        backgroundColor = themeString.secondaryContainer,
        snackbarHost = {
            scaffoldState.snackbarHostState
        },
        bottomBar = {
            MyBottomNavigation()
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "扫码功能"
                        )
                    }
                },
                backgroundColor = md_theme_dark_primary
            ) {
                Icon(Icons.Default.Build, null, tint = Color.White)
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            MySnackBar(
                snackbarHostState = scaffoldState.snackbarHostState,
                onDismiss = {
                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                }
            )
            Text("主页界面")
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KKNeedTheme {
//        Sample()
        val items = listOf<ItemData>(
            ItemData(
                R.drawable.frame1,
                "找寻食品信息",
                "科学评判你能买到的预包装食品，准确记录食品信息，健康生活暖宝宝。"
            ),
            ItemData(
                R.drawable.frame2,
                "找寻食品信息",
                "科学评判你能买到的预包装食品，准确记录食品信息，健康生活暖宝宝。"
            ),
            ItemData(
                R.drawable.frame3,
                "找寻食品信息",
                "科学评判你能买到的预包装食品，准确记录食品信息，健康生活暖宝宝。"
            )
        )
        CustomProgress(items[1])
        // A surface container using the 'background' color from the theme
//        HorizontalPager(count = 0) {
//            CustomProgress(items[it])
//        }
    }
}