package com.example.kkneed

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.ui.theme.KKNeedTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KKNeedTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Sample()
                }
            }
        }
    }
}
data class Item(
    val index:Int,
    val name: String,
    val icon: ImageVector,
)

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
    val items = listOf(
        Item(0,"主页", icon = Icons.Default.Home),
        Item(1,"商城", icon = Icons.Default.ShoppingCart),
        Item(2,"记录", icon = Icons.Default.Check),
        Item(3,"个人", icon = Icons.Default.Person)
    )
    BottomAppBar(cutoutShape = RoundedCornerShape(50), contentPadding = PaddingValues(5.dp,5.dp)) {
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
            onClick = {selectedItem = 0},
            icon = { Icon(items[0].icon,null) },
            alwaysShowLabel = false,
            label = { Text(items[0].name)},
            modifier = Modifier.padding(10.dp,0.dp,10.dp,0.dp)
        )
        BottomNavigationItem(
            selected = selectedItem == 1,
            onClick = {selectedItem = 1},
            icon = { Icon(items[1].icon,null) },
            alwaysShowLabel = false,
            label = { Text(items[1].name)},
            modifier = Modifier.padding(0.dp,0.dp,40.dp,0.dp)
        )
        BottomNavigationItem(
            selected = selectedItem == 2,
            onClick = {selectedItem = 2},
            icon = { Icon(items[2].icon,null) },
            alwaysShowLabel = false,
            label = { Text(items[2].name)},
            modifier = Modifier.padding(40.dp,0.dp,0.dp,0.dp)
        )
        BottomNavigationItem(
            selected = selectedItem == 3,
            onClick = {selectedItem = 3},
            icon = { Icon(items[3].icon,null) },
            alwaysShowLabel = false,
            label = { Text(items[3].name)},
            modifier = Modifier.padding(10.dp,0.dp,10.dp,0.dp)
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Sample() {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            scaffoldState.snackbarHostState
        },
        topBar = {
            TopAppBar(
                title = { Text("主页") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, null)
                    }
                }
            )
        },
        bottomBar = {
            MyBottomNavigation()
//            MyBottomAppBar()
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "扫码功能"
                    )
                }
            }
            ) {
                Icon(Icons.Default.Build, null, tint = Color.Black)
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KKNeedTheme {
        Sample()
    }
}