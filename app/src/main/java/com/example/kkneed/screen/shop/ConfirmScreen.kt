package com.example.kkneed.screen.shop

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.OrderBottomBar
import com.example.kkneed.ui.theme.KKNeedTheme


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ConfirmScreen(navController: NavController) {

    val checkedState = remember {
        mutableStateOf(true)
    }

    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            MostUseTopAppBar(
                appBarHeight = 64.dp,
                navController = navController,
                title = "确认订单"
            )
        },
        bottomBar = {
            OrderBottomBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 80.dp)
        ) {
            //第一张卡
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(12.dp),
                onClick = {},
                backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
                elevation = 4.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(vertical = 10.dp),
                    ) {
                        Text(
                            "收件人：康康  12312345678",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "收件地址：广州 番禺区 康康家",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    }

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.chevron_right), null,
                            tint = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            //第二张卡
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(105.dp),
                shape = RoundedCornerShape(12.dp),
                onClick = {},
                backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
                elevation = 4.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.head),
                            contentDescription = "",
                            modifier = Modifier
                                .size(88.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.None,
                            alignment = Alignment.TopCenter,
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Image(
                            painter = painterResource(R.drawable.head),
                            contentDescription = "",
                            modifier = Modifier
                                .size(88.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.None,
                            alignment = Alignment.TopCenter,
                        )
                    }
                    Row(
                        modifier = Modifier
//                            .fillMaxHeight()
//                            .width(74.dp)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        androidx.compose.material.Text(
                            "共两件",
                            color = MaterialTheme.colorScheme.outline,
                            style = MaterialTheme.typography.labelSmall
                        )
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.chevron_right), null,
                                tint = MaterialTheme.colorScheme.outline,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            //文字
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(26.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                androidx.compose.material.Text(
                    "总运费",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall
                )
                androidx.compose.material.Text(
                    "￥0.0",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(26.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                androidx.compose.material.Text(
                    "优惠券",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall
                )
                androidx.compose.material.Text(
                    "-￥10.0",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                shape = RoundedCornerShape(12.dp),
                onClick = {},
                backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
                elevation = 0.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                ) {
                    Text(
                        "给康康留言：",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.outline,
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            //文字
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(26.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                androidx.compose.material.Text(
                    "共2件商品 总计：",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall
                )
                androidx.compose.material.Text(
                    "￥34.6",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = MaterialTheme.colorScheme.outline, thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(26.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                androidx.compose.material.Text(
                    "支付方式",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.wechat),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .clip(RoundedCornerShape(0.dp)),
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.TopCenter,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    androidx.compose.material.Text(
                        "微信支付",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    modifier = Modifier.padding(0.dp),
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.zhifubao),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .clip(RoundedCornerShape(0.dp)),
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.TopCenter,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    androidx.compose.material.Text(
                        "微信支付",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    modifier = Modifier.padding(0.dp),
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = MaterialTheme.colorScheme.outline, thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            androidx.compose.material.Text(
                "订单说明",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            androidx.compose.material.Text(
                "订单说明详情内容订单说明详情内容订单说明详情",
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.labelSmall
            )
            Spacer(modifier = Modifier.height(88.dp))
        }
    }
}

@Preview
@Composable
fun PreviewEditNoteScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ConfirmScreen(navController)
    }
}
