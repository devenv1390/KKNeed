package com.example.kkneed.screen

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.screen.login.RandomPosition
import com.example.kkneed.ui.HomeCommunityCard
import com.example.kkneed.ui.HomeFoodCard
import com.example.kkneed.ui.HomeRecordCard
import com.example.kkneed.ui.HomeTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = { HomeTopAppBar(64.dp, navController) }
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.shopcard),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(0))
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
                Spacer(modifier = Modifier.height(8.dp))
                SubTitleRow()
                LazyRow(modifier = Modifier.padding(start = 16.dp)){
                    item { HomeCommunityCard() }
                    item { HomeCommunityCard() }
                    item { HomeCommunityCard() }
                    item { HomeCommunityCard() }
                    item { HomeCommunityCard() }
                }
                SubTitleRow2()
                HomeRecordCard()
                SubTitleRow3()
                Row(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(){
                        item { HomeFoodCard() }
                        item { HomeFoodCard() }
                        item { HomeFoodCard() }
                        item { HomeFoodCard() }
                        item { HomeFoodCard() }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    LazyColumn(){
                        item { HomeFoodCard() }
                        item { HomeFoodCard() }
                        item { HomeFoodCard() }
                        item { HomeFoodCard() }
                        item { HomeFoodCard() }
                    }
                }
            }
        }
    }
}

//小标题栏
@Composable
fun SubTitleRow(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id = R.drawable.forum),
                contentDescription = "Localized description",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(24.dp)
            )
        }
        androidx.compose.material3.Text(
            "康康社区",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {},
                modifier = Modifier.offset(x=22.dp)) {
                androidx.compose.material3.Text(
                    "查看更多",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline,
                )
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}

@Composable
fun SubTitleRow2(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id = R.drawable.visibility),
                contentDescription = "Localized description",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(24.dp)
            )
        }
        androidx.compose.material3.Text(
            "我的记录",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun SubTitleRow3(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id = R.drawable.recommend),
                contentDescription = "Localized description",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(24.dp)
            )
        }
        androidx.compose.material3.Text(
            "推荐食品",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {},
                modifier = Modifier.offset(x=22.dp)) {
                androidx.compose.material3.Text(
                    "进入商城",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline,
                )
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.outline
                )
            }
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