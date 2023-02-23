package com.example.kkneed.screen.shop

import android.annotation.SuppressLint
import android.os.Message
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.*
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
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.ServiceBottomBar
import com.example.kkneed.ui.theme.KKNeedTheme

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ServiceScreen(navController: NavController) {
    Scaffold(
        backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.background,
        topBar = {
            MostUseTopAppBar(
                appBarHeight = 64.dp,
                navController = navController,
                title = "康康客服"
            )
        },
        bottomBar = { ServiceBottomBar() }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
            ) {
                Image(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(
                            CircleShape
                        ),
                    painter = painterResource(R.drawable.dog),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(6.dp))
                Card(

                    shape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 0.dp),
                    onClick = {},
                    backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.surfaceColorAtElevation(
                        1.dp
                    ),
                    elevation = 0.dp,
                ) {
                    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier=Modifier.padding(bottom=8.dp)){
                            androidx.compose.material3.Text(
                                "康康",
                                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                                color = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            androidx.compose.material3.Text(
                                "Hi ，我是康康.\n" +
                                        "我想知道我的东西发货了吗？",
                                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                            )
                        }

                        androidx.compose.material3.Text(
                            "03:30",
                            style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                            color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                ,
                verticalAlignment = Alignment.Bottom,
            ) {
                Image(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(
                            CircleShape
                        ),
                    painter = painterResource(R.drawable.dog),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(6.dp))
                Card(

                    shape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 0.dp),
                    onClick = {},
                    backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.surfaceColorAtElevation(
                        1.dp
                    ),
                    elevation = 0.dp,
                ) {
                    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier=Modifier.padding(bottom=8.dp)){
                            androidx.compose.material3.Text(
                                "康康",
                                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                                color = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            androidx.compose.material3.Text(
                                "Hi ，我是康康.\n" +
                                        "我想知道我的东西发货了吗？",
                                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                            )
                        }

                        androidx.compose.material3.Text(
                            "03:31",
                            style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                            color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                ,
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End,
            ) {
                Card(

                    shape = RoundedCornerShape(12.dp, 12.dp, 0.dp, 12.dp),
                    onClick = {},
                    backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.secondaryContainer,
                    elevation = 0.dp,
                ) {
                    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier=Modifier.padding(bottom=8.dp)){
                            androidx.compose.material3.Text(
                                "客服康康",
                                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                                color = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            androidx.compose.material3.Text(
                                "Hi ，我是康康.\n" +
                                        "正在抓紧为您安排，请您稍等",
                                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                            )
                        }

                        androidx.compose.material3.Text(
                            "03:32",
                            style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                            color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
                Spacer(modifier = Modifier.width(6.dp))
                Image(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(
                            CircleShape
                        ),
                    painter = painterResource(R.drawable.profile),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun Message(
    onAuthorClick: () -> Unit,
    msg: Message,
    isUserMe: Boolean,
    isLastMessageByTime: Boolean,
) {
    Row()
    {
        if (isLastMessageByTime) {
            //显示头像
            Image(
                modifier = Modifier
                    .clickable(onClick = onAuthorClick)
                    .padding(horizontal = 16.dp)
                    .size(42.dp)
                    .clip(
                        CircleShape
                    )
                    .align(Alignment.Top),
                painter = painterResource(id = if (isUserMe) R.drawable.dog else R.drawable.head),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
        } else {
            //当不是首条消息时不显示头像
            Spacer(modifier = Modifier.width(74.dp))
        }
        //消息内容
        AuthorAndTextMessage(
            msg = msg,
            isUserMe = isUserMe,
            isLastMessageByTime = isLastMessageByTime,
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(1f)
        )
    }
}

@Composable
fun AuthorAndTextMessage(
    msg: Message,
    isUserMe: Boolean,
    isLastMessageByTime: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        if (isLastMessageByTime) {
//            AuthorNameTimestamp(msg)

        }
        ChatItemBubble(msg, isUserMe)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun ChatItemBubble(msg: Message, userMe: Boolean) {
    Surface(color = MaterialTheme.colors.surface) {

    }
}


@Preview
@Composable
fun PreviewServiceScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ServiceScreen(navController)

    }
}