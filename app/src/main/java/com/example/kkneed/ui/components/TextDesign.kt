package com.example.kkneed.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kkneed.ui.theme.BaseDP

@Composable
private fun TextDesign() {
    Column(
        verticalArrangement = Arrangement.spacedBy(BaseDP),
        modifier = Modifier
            .fillMaxSize()
            .padding(BaseDP)
    ) {
        Text(
            text = "Headline 4",
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "Headline 5",
            style = MaterialTheme.typography.h5
        )
        Text(
            text = "Headline 6",
            style = MaterialTheme.typography.h6
        )
        Text(
            text = "Body 1",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "Body 2",
            style = MaterialTheme.typography.body2
        )
        Text(
            text = "Subtitle 1",
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "Subtitle 2",
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = "Caption",
            style = MaterialTheme.typography.caption
        )
        Text(
            text = "Overline",
            style = MaterialTheme.typography.overline
        )
    }
}