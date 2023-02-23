package com.example.kkneed.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.SCANNER_ROUTE
import com.example.kkneed.ui.*
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.md_theme_dark_primary

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = { HomeTopAppBar(64.dp, navController) },
        bottomBar = {
            MyBottomNavigation(navController = navController,0)
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 2.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.banner),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(0))
                    .height(200.dp)
                    .clickable { navController.navigate(AllScreen.Day.route) },
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Spacer(modifier = Modifier.height(8.dp))
            SubTitleRow(navController)
//            Row(modifier = Modifier.padding(start = 16.dp)) {
//                HomeCommunityCard()
//                HomeCommunityCard()
//                HomeCommunityCard()
//                HomeCommunityCard()
//            }
            LazyRow(modifier = Modifier.padding(start = 16.dp)) {
                item { HomeCommunityCard(R.drawable.community1,"健康食品知多少？","你真的了解健康食品吗？你知道怎样的包装食品才算是真健康吗？",navController) }
                item { HomeCommunityCard(R.drawable.guominyuan,"过敏食物分享","你真的了解健康食品吗？你知道怎样的包装食品才算是真健康吗？",navController) }
                item { HomeCommunityCard(R.drawable.tangniaobing,"健康食品知多少？","你真的了解健康食品吗？你知道怎样的包装食品才算是真健康吗？",navController) }
                item { HomeCommunityCard(R.drawable.community1,"健康食品知多少？","你真的了解健康食品吗？你知道怎样的包装食品才算是真健康吗？",navController) }
                item { HomeCommunityCard(R.drawable.community1,"健康食品知多少？","你真的了解健康食品吗？你知道怎样的包装食品才算是真健康吗？",navController) }
            }
            SubTitleRow2()
            HomeRecordCard(navController)
            SubTitleRow3(navController)
            Row(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Center) {
                Column(verticalArrangement =Arrangement.spacedBy(8.dp)) {
                    HomeFoodCard(navController)
                    HomeFoodCard(navController)
                    HomeFoodCard(navController)
                    HomeFoodCard(navController)
                    HomeFoodCard(navController)
                }
//                LazyColumn() {
//                    item { HomeFoodCard() }
//                    item { HomeFoodCard() }
//                    item { HomeFoodCard() }
//                    item { HomeFoodCard() }
//                    item { HomeFoodCard() }
//                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(verticalArrangement =Arrangement.spacedBy(8.dp)) {
                    HomeFoodCard(navController)
                    HomeFoodCard(navController)
                    HomeFoodCard(navController)
                    HomeFoodCard(navController)

                }
//                LazyColumn() {
//                    item { HomeFoodCard() }
//                    item { HomeFoodCard() }
//                    item { HomeFoodCard() }
//                    item { HomeFoodCard() }
//                    item { HomeFoodCard() }
//                }
            }
            Spacer(modifier = Modifier.height(88.dp))

        }

    }
}


//小标题栏
@Composable
fun SubTitleRow(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically,
            ){
            Icon(painter = painterResource(id = R.drawable.forum),
                null,modifier=Modifier.size(24.dp))
            Text(text = "康康社区",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 8.dp))
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = {navController.navigate(AllScreen.Community.route)},
                modifier = Modifier.offset(x = 22.dp)
            ) {
                androidx.compose.material3.Text(
                    "查看更多 > ",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Composable
fun SubTitleRow2() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
        ){
            Icon(
                painter = painterResource(id = R.drawable.visibility),
                contentDescription = "Localized description",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "我的记录",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun SubTitleRow3(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
        ){
            Icon(
                painter = painterResource(id = R.drawable.recommend),
                contentDescription = "Localized description",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "推荐食品",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}