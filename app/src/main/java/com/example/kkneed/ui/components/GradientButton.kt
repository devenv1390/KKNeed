package com.example.kkneed.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(
    modifier: Modifier,
    textId: String,
    onClick: () -> Unit,
) {

    val gradient = Brush.horizontalGradient(
        listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.inversePrimary
        )
    )

    CustomButton(
        onClick = onClick,
        modifier = modifier,
        gradient = gradient,
        color = Color.Transparent,
        cornerRadius = 50.dp,
        textId = textId,
        contentTextStyle = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
    )

}
@Preview
@Composable
fun GradientPreview(){
    GradientButton(
        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
        textId = "+关注",
        onClick = { /*TODO*/ })
}
