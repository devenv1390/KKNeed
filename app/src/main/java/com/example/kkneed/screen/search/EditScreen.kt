package com.example.kkneed.screen.search

import android.Manifest
import android.annotation.SuppressLint
import android.webkit.PermissionRequest
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.ui.BackButton
import com.example.kkneed.ui.EditCard
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class,
    ExperimentalPermissionsApi::class
)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditScreen(navController: NavController) {
    val permission = Manifest.permission.READ_EXTERNAL_STORAGE
// 定义 Permission State
    val permissionState = rememberPermissionState(permission)
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "发布评价")
        },
        bottomBar = {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 28.dp),
                horizontalArrangement = Arrangement.Center){
                GradientButton(modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.8f),
                    textId = "发布评价", onClick = {

                    }
                )
            }
        }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
            EditCard()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp) // 外边距
                    .clickable { }
                    .clip(RoundedCornerShape(12.dp))
                    .height(72.dp),

                // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
                // 将无法显示波纹效果

                elevation = 2.dp, // 设置阴影
                onClick = {},
                backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
            )
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp,end=16.dp)
                )
                {
                    Text(
                        "综合评分",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center){
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.fillstar),null,
                                tint = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.size(24.dp))
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.fillstar),null,
                                tint = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.size(24.dp))
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.fillstar),null,
                                tint = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.size(24.dp))
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.fillstar),null,
                                tint = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.size(24.dp))
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.fillstar),null,
                                tint = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.size(24.dp))
                        }
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp) // 外边距
                    .clip(RoundedCornerShape(12.dp))
                    .clickable{}
                    .height(266.dp),

                // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
                // 将无法显示波纹效果

                elevation = 2.dp, // 设置阴影
                onClick = {permissionState.launchPermissionRequest() },
                backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
            )
            {
                Column(modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxSize()){

                        var text by remember { mutableStateOf("") }
                        TextField(
                            modifier=Modifier.height(124.dp),
                            value = text,
                            onValueChange = {
                                text = it
                            },
                            label={
                                Text(text = "可以从口味、健康等多个角度评论产品，帮助大家更好的了解产品",
                                    color = MaterialTheme.colorScheme.outline)
                            },
                            leadingIcon = {
                                Row(verticalAlignment = Alignment.Top){
                                    Icon(painter = painterResource(id = R.drawable.edit), null)
                                }

                            },
                            colors=TextFieldDefaults.textFieldColors(
                                textColor = MaterialTheme.colorScheme.outline,
                                containerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                            )
                        )
                    Spacer(modifier = Modifier.height(12.dp))
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .background(Color.Transparent),

                            // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
                            // 将无法显示波纹效果
                            shape=RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                            onClick = {},
                            backgroundColor = Color.Transparent,
                        )
                        {
                            Column(modifier=Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center){
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(painter = painterResource(id = R.drawable.camera),null,
                                    modifier=Modifier.size(24.dp))
                                }
                                Text(
                                    "上传图片",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                }
        }
    }
}
}
@Preview
@Composable
fun EditPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        EditScreen(navController)
    }
}