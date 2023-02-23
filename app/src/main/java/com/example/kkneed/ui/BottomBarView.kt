package com.example.kkneed.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kkneed.R
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.BottomItemScreen
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.md_theme_light_tertiaryContainer

@Composable
fun MyBottomNavigation(
    navController: NavController,
    index: Int
) {//第二种设计方案，采用BottomAppBar与BottomNavigationItem结合的方式，解决了选项卡按下后没有外观变化的缺点，但动画和按键的布局范围比较难控制
    var selectedItem by remember { mutableStateOf(index) }
    val themeString = MaterialTheme.colorScheme
    val navItems = listOf(
        BottomItemScreen.Home,
        BottomItemScreen.Shop,
        BottomItemScreen.Customize,
        BottomItemScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomAppBar(
        cutoutShape = RoundedCornerShape(50),
        contentPadding = PaddingValues(5.dp, 5.dp),
        backgroundColor = themeString.background,
        modifier = Modifier.navigationBarsPadding()
    ) {
       //不能采用遍历的方式创建导航选项卡，因为选项卡需要单独设置间隔值
        BottomNavigationItem(
            selected = selectedItem == 0,
            onClick = {
                navController.navigate(navItems[0].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(navItems[0].icon, null) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
            alwaysShowLabel = false,
            label = { Text(navItems[0].title) },
            modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)
        )
        BottomNavigationItem(
            selected = selectedItem == 1,
            onClick = {
                navController.navigate(navItems[1].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(navItems[1].icon, null) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
            alwaysShowLabel = false,
            label = { Text(navItems[1].title) },
            modifier = Modifier.padding(0.dp, 0.dp, 40.dp, 0.dp)
        )
        BottomNavigationItem(
            selected = selectedItem == 2,
            onClick = {
                navController.navigate(navItems[2].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(navItems[2].icon, null) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
            alwaysShowLabel = false,
            label = { Text(navItems[2].title) },
            modifier = Modifier.padding(40.dp, 0.dp, 0.dp, 0.dp)
        )
        BottomNavigationItem(
            selected = selectedItem == 3,
            onClick = {
                navController.navigate(navItems[3].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(navItems[3].icon, null) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
            alwaysShowLabel = false,
            label = { Text(navItems[3].title) },
            modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)
        )
    }
}

@Composable
fun DetailBottomBar(navController: NavController, barcode: String) {
    var selected by remember { mutableStateOf(false) }
    androidx.compose.material3.BottomAppBar(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        tonalElevation = 0.dp,
        contentPadding = PaddingValues(start = 8.dp),
        actions = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { navController.navigate(AllScreen.EditProduct.route) }) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = R.drawable.editnote),
                        contentDescription = "Localized description",
                        tint = MaterialTheme.colorScheme.secondaryContainer
                    )
                }
                Text(
                    "编辑产品",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { navController.navigate(AllScreen.Compare.route + "/${barcode}") }) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = R.drawable.compare),
                        contentDescription = "Localized description",
                        tint = MaterialTheme.colorScheme.secondaryContainer
                    )
                }
                Text(
                    "对比",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = {
                    selected = !selected
                }) {
                    if (selected) {
                        androidx.compose.material3.Icon(

                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.secondaryContainer
                        )
                    } else {
                        androidx.compose.material3.Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.fillstar),
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.secondaryContainer
                        )
                    }
                }
                Text(
                    "1811",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { AllScreen.Comment.route }) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = "Localized description",
                        tint = MaterialTheme.colorScheme.secondaryContainer
                    )
                }
                Text(
                    "2302",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        floatingActionButton = {
            GradientButton(modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f),
                textId = "加入已购买列表", onClick = {

                }
            )
        }
    )
}

//购物车
@Composable
fun ShopCartBottomBar(navController: NavController) {
    val checkedState = remember {
        mutableStateOf(true)
    }
    androidx.compose.material3.BottomAppBar(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        tonalElevation = 0.dp,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        actions = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    modifier = Modifier.padding(0.dp),
                )
            }

        },
        floatingActionButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "总计",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    "￥34.6",
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(modifier = Modifier.width(8.dp))
                GradientButton(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(0.4f),
                    textId = "结算",
                    onClick = {
                        navController.navigate(AllScreen.Confirm.route)
                    },
                )
            }
        }
    )
}

//确认订单
@Composable
fun OrderBottomBar() {
    androidx.compose.material3.BottomAppBar(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        tonalElevation = 0.dp,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        actions = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "总计",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    "￥34.6",
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        floatingActionButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GradientButton(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(0.4f),
                    textId = "去付款",
                    onClick = {
                    },
                )
            }
        }
    )
}


//客服
@Composable
fun ServiceBottomBar() {
    var text by remember { mutableStateOf("") }
    Column() {
        Spacer(
            modifier = Modifier
                .height(16.dp)
                .background(androidx.compose.material.MaterialTheme.colors.background)
        )
        Row(
            modifier = Modifier
                .fillMaxSize()

                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                decorationBox = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "")
                        Box(
//                        modifier = Modifier
//                            .weight(1f),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (text.isEmpty()) {
                                Text(
                                    text = "编辑消息~",
                                    style = TextStyle(Color(0, 0, 0, 128))
                                )
                            }
                            it()
                        }
                        if (text.isNotEmpty()) {
                            androidx.compose.material.IconButton(
                                onClick = { text = "" },
                                modifier = Modifier.size(16.dp)
                            ) {
                                Icon(imageVector = Icons.Filled.Close, contentDescription = "")
                            }
                        }
                    }
                },
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .size(328.dp, 44.dp)
            )
            androidx.compose.material3.IconButton(onClick = { }) {
                androidx.compose.material3.Icon(
                    painter = painterResource(id = R.drawable.telegram3),
                    contentDescription = "Localized description",
                    tint = androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
    }
}

//商城的商品详情
@Composable
fun ShopDetailBottomBar(navController: NavController) {
    androidx.compose.material3.BottomAppBar(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        tonalElevation = 0.dp,
        contentPadding = PaddingValues(start = 8.dp),
        actions = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { navController.navigate(AllScreen.ShoppingCart.route) }) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = R.drawable.shoppingcart),
                        contentDescription = "Localized description",
                        tint = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    "购物车",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { navController.navigate(AllScreen.Chose.route) }) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = R.drawable.compare),
                        contentDescription = "Localized description",
                        tint = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    "对比",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { navController.navigate(AllScreen.Service.route) }) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = R.drawable.support_agent),
                        contentDescription = "Localized description",
                        tint = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    "客服",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        floatingActionButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val context = LocalContext.current
                androidx.compose.material3.Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "成功加入购物车！",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        md_theme_light_tertiaryContainer
                    )
                ) {
                    Text(
                        text = "加入购物车",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onTertiary,
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                GradientButton(
                    modifier = Modifier
                        .height(40.dp)
                        .width(105.dp),
                    textId = "立即购买",
                    onClick = {
                        navController.navigate(AllScreen.Confirm.route)
                    },
                )
            }
        }
    )
}


@Preview
@Composable
fun BottomBarScreen() {
    KKNeedTheme {
        OrderBottomBar()
    }
}

