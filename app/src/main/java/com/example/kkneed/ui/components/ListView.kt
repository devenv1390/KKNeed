package com.example.kkneed.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kkneed.R

//关注列表
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun WatchList(){
    Column (){
        ListItem(
            headlineText = { Text(
                "康康",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            },
            supportingText = { Text(
                "30000粉丝 3w+赞",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline
            ) },
            trailingContent = {
                //取消关注按钮
                Button(
                    onClick = { /* Do something! */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.outline
                    ),
                ) {

                    Text("取消关注",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            leadingContent = {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(32.dp),
                    contentScale = ContentScale.Crop
                )
            },

            )
        Divider()
}
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FanList(){
    Column (){
        ListItem(
            headlineText = { Text(
                "康康",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            },
            supportingText = { Text(
                "30000粉丝 3w+赞",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline
            ) },
            trailingContent = {
                Button(
                    onClick = { /* Do something! */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                ) {
                    Icon(
                    Icons.Filled.Add,
                    contentDescription = "",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))

                    Text("关注",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            leadingContent = {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(32.dp),
                    contentScale = ContentScale.Crop
                )
            },

            )
        Divider()
    }
}