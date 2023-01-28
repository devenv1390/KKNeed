package com.example.kkneed.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kkneed.model.GuideScreenItemData

@Composable
fun CustomProgress(itemData: GuideScreenItemData) {
    Column(
        modifier = Modifier
            .height(700.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = itemData.image), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = itemData.title,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(40.dp,20.dp)
        )
        Text(
            text = itemData.content,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(40.dp,20.dp)
        )
    }
}