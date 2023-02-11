package com.example.kkneed.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kkneed.R
import com.example.kkneed.model.GuideScreenItemData
import com.example.kkneed.ui.theme.KKNeedTheme

@Composable
fun CustomProgress(itemData: GuideScreenItemData) {
    Column(
        modifier = Modifier
            .height(700.dp)
            .background(MaterialTheme.colorScheme.background),
    ) {
        Image(
            painter = painterResource(id = itemData.image), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter
        )
        Text(
            text = itemData.title,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(40.dp, 20.dp)
        )
        Text(
            text = itemData.content,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(40.dp, 20.dp)
        )


    }
}
@Preview
@Composable
fun progressBar(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        CircularProgressIndicator(
            modifier = Modifier.padding(16.dp),
            color=MaterialTheme.colorScheme.primary,
            strokeWidth = Dp(value=4F)
        )
    }
}

@Preview
@Composable
fun Preview() {
    KKNeedTheme {
        Column(
            modifier = Modifier
                .height(600.dp)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.frame1), contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "找寻食品信息",
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(40.dp, 20.dp)
            )
            Text(
                text = "科学评判你能买到的预包装食品，准确记录食品信息，健康生活暖宝宝。",
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(40.dp, 20.dp)
            )
        }
    }
}
